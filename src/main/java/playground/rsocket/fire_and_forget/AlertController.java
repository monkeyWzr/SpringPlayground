package playground.rsocket.fire_and_forget;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import reactor.core.publisher.Mono;

@Controller
public class AlertController {

    @MessageMapping("alert")
    public Mono<Void> setAlert(Mono<Alert> alertMono) {
        return alertMono
                .doOnNext(alert -> {
                    System.out.println(
                            alert.getLevel() + " alert"
                                    + " ordered by " + alert.getOrderedBy()
                                    + " at " + alert.getOrderedAt());
                })
                .thenEmpty(Mono.empty());
    }

}
