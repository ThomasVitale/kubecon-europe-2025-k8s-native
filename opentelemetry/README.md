# OpenTelemetry

## Run the application with dev services

```shell
./gradlew bootRun
```

An Ollama container is automatically started and connected to the application.
Furthermore, the Grafana LGTM platform is started in the background, collecting logs, metrics, and traces from the application via OpenTelemetry.

The application logs will show you the URL where you can access the Grafana observability platform.

```log
...o.t.grafana.LgtmStackContainer: Access to the Grafana dashboard: http://localhost:38125
```

Test the integration with Ollama by sending a chat request:

```shell
http :8080/chat
```

Next, open the Grafana UI and check the generated telemetry.

By default, logs, metrics, and traces are exported via OTLP using the HTTP/Protobuf format.

In Grafana, you can query the traces from the "Explore" page, selecting the "Tempo" data source. You can also explore metrics in "Explore > Metrics" and logs in "Explore > Logs".
