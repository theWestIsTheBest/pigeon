package com.jmurin

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class TaskResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
          .`when`().get("/hello-resteasy-reactive")
          .then()
             .statusCode(200)
             .body(`is`("Hello RESTEasy Reactive"))
    }

}