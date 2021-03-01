package com.jmurin

import io.smallrye.mutiny.Uni
import io.smallrye.reactive.messaging.MutinyEmitter
import io.smallrye.reactive.messaging.amqp.OutgoingAmqpMetadata
import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Message
import org.jboss.resteasy.reactive.RestForm
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.Instant
import java.util.concurrent.CompletableFuture
import javax.inject.Inject
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("tasks")
class TaskResource {

    private val logger: Logger = LoggerFactory.getLogger(TaskResource::class.java)

    @Inject
    @Channel("task-finished")
    lateinit var taskFinishedEmitter: MutinyEmitter<String>

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    fun startTask(@RestForm customerId: String, @RestForm timeComplexity: Int): Uni<String> {

        logger.info("entering /start-task; customerId = {}; timeComplexity = {}",
                customerId, timeComplexity)

        // TODO: start a long running task in the background that once finished will produce a message

        val messageText: String = "TEST MESSAGE TEXT"

        val metadata: OutgoingAmqpMetadata = OutgoingAmqpMetadata.builder()

            .withAddress("anycast://my-custom-address")

            .build()

        val message: Message<String> = Message.of(messageText,
            {
                logger.info("message acked")
                CompletableFuture.completedFuture(null)
            },
            {
                logger.info("message nacked: {}", it.message)
                CompletableFuture.completedFuture(null)
            }
        )

        taskFinishedEmitter.send(message.addMetadata(metadata))

        return Uni.createFrom().item("DONE")

    }
}