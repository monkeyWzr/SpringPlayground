package playground.rsocket.request_response;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import reactor.core.publisher.Mono;

@Controller
public class GreetingController {

    @MessageMapping("greeting/{name}")
    public Mono<String> handleGreeting(@DestinationVariable("name") String name, Mono<String> greetingMono) {
        return greetingMono
                .doOnNext(greeting -> System.out.println("Received a greeting: " + greeting))
                .map(greeting -> "Hello back to you, " + name + "!");
    }

}
