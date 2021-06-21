## RSocket

[RSocket Protocol](https://github.com/rsocket/rsocket)

Reactive style. Supports TCP socket(by default) and WebSocket.

Specify port:

```yml
spring:
  rsocket:
    server:
      port: 7000
```

### Four communication models

* **Request-Response**: single request, single response
* **Request-Stream**: single request and responds with a stream
* **Fire-and-Forget**: single request and no response
* **Channel**: bidirectional channel opened by request from client

### @MessageMapping

Use `@MessageMapping` to bind handler methods. Seem as `@GetMapping` and others

### RSocket over WebSocket(HTTP)

Need WebFlux because the server-side needs to handle HTTP requests.

Config in the application's property file:

```yml
spring:
  rsocket:
    server:
      transport: websocket
      mapping-path: /rsocket
```