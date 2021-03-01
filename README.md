# pigeon project

This project uses Quarkus and Smallrye Reactive Messaging Library with the AMQP connector.

### first you need to build a custom activemq artemis docker image

`docker build . -t artemis:v1 -f ./src/main/docker/Dockerfile.ActiveMQArtemis`

### start artemis

`docker run --rm --name artemis -p 8161:8161 -p 5672:5672 --env ARTEMIS_USERNAME=adm --env ARTEMIS_PASSWORD=guest artemis:v1`

## run the microservice in dev mode

```shell script
./gradlew quarkusDev
```

### use the endpoint to send a message to the broker

`curl http://localhost:8080/tasks -d 'customerId=5466AEYRHD' -d 'timeComplexity=10'`
