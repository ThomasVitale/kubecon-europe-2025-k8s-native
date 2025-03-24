# Testcontainers

## Run integration tests with dev services

```shell
./gradlew test
```

An Ollama container is automatically started and connected to the application while running the integration tests.

## Run the application with dev services

```shell
./gradlew bootRun
```

An Ollama container is automatically started and connected to the application.

```shell
podman ps
```

Test the integration with Ollama by sending a chat request:

```shell
http :8080/chat
```
