# pigeon project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./gradlew build
```
It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/pigeon-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.

## Related guides

- Minikube ([guide](https://quarkus.io/guides/kubernetes)): Generate Minikube resources from annotations
- SmallRye Reactive Messaging - AMQP Connector ([guide](https://quarkus.io/guides/amqp)): Connect to AMQP with Reactive Messaging
- Hibernate Validator ([guide](https://quarkus.io/guides/validation)): Validate object properties (field, getter) and method parameters for your beans (REST, CDI, JPA)
- RESTEasy JSON-B ([guide](https://quarkus.io/guides/rest-json)): JSON-B serialization support for RESTEasy
- Logging GELF ([guide](https://quarkus.io/guides/centralized-log-management)): Log using the Graylog Extended Log Format and centralize your logs in ELK or EFK
- Kotlin ([guide](https://quarkus.io/guides/kotlin)): Write your services in Kotlin
- Reactive PostgreSQL client ([guide](https://quarkus.io/guides/reactive-sql-clients)): Connect to the PostgreSQL database using the reactive pattern
- SmallRye Health ([guide](https://quarkus.io/guides/microprofile-health)): Monitor service health
- Logging Sentry ([guide](https://quarkus.io/guides/logging-sentry)): Use Sentry, a self-hosted or cloud-based error monitoring solution
- Kubernetes ([guide](https://quarkus.io/guides/kubernetes)): Generate Kubernetes resources from annotations
- Micrometer metrics ([guide](https://quarkus.io/guides/micrometer-metrics)): Instrument the runtime and your application with dimensional metrics using Micrometer.

## Provided examples

### RESTEasy Reactive example

Rest is easy peasy & reactive with this Hello World RESTEasy Reactive resource.

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)


### pointers to documentation
[quarkus and kotlin](https://quarkus.io/guides/kotlin)
[mutiny and kotlin](https://smallrye.io/smallrye-mutiny/guides/kotlin)
new way of reacting routes: [RESTEasy](https://quarkus.io/blog/resteasy-reactive/)

