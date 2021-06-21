package playground.rsocket;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;

import playground.rsocket.channel.GratuityIn;
import playground.rsocket.channel.GratuityOut;
import playground.rsocket.fire_and_forget.Alert;
import playground.rsocket.request_stream.StockQuote;
import reactor.core.publisher.Flux;

@Configuration
public class ClientConfig {

//    @Bean
    public ApplicationRunner sender(RSocketRequester.Builder requesterBuilder) {
        return args -> {
            RSocketRequester tcp = requesterBuilder.tcp("localhost", 7000);

            String who = "Wu";
            tcp.route("greeting/{name}", who)
            .data("Hello RSocket")
            .retrieveMono(String.class)
            .subscribe(response -> System.out.println("Got a response: " + response));
        };
    }

//    @Bean
    public ApplicationRunner sender2(RSocketRequester.Builder requesterBuilder) {
        return args -> {
            RSocketRequester tcp = requesterBuilder.tcp("localhost", 7000);
            String symbol = "XYZ";

            tcp.route("stock/{symbol}", symbol)
            .retrieveFlux(StockQuote.class)
            .doOnNext(stockQuote -> {
                System.out.println(
                        "Price of " + stockQuote.getSymbol() +
                        " : " + stockQuote.getPrice() +
                        "  (at " + stockQuote.getTimestamp() + ")");
            })
            .subscribe();
        };
    }

//    @Bean
    public ApplicationRunner fireAndForgetSender(RSocketRequester.Builder requesterBuilder) {
        return args -> {
            RSocketRequester tcp = requesterBuilder.tcp("localhost", 7000);

            tcp.route("alert")
            .data(new Alert(Alert.Level.RED, "Wu", Instant.now()))
            .send()
            .subscribe();
            System.out.println("Alert sent");
        };
    }

    @Bean
    public ApplicationRunner channelSender(RSocketRequester.Builder requesterBuilder) {
        return args -> {
            RSocketRequester tcp = requesterBuilder.tcp("localhost", 7000);

            Flux<GratuityIn> gratuityInFlux =
                    Flux.fromArray(new GratuityIn[] {
                        new GratuityIn(new BigDecimal(35.50), 18),
                        new GratuityIn(new BigDecimal(10.00), 15),
                        new GratuityIn(new BigDecimal(23.25), 20),
                        new GratuityIn(new BigDecimal(52.75), 18),
                        new GratuityIn(new BigDecimal(80.00), 15)
                    })
                    .delayElements(Duration.ofSeconds(1));

            tcp.route("gratuity")
            .data(gratuityInFlux)
            .retrieveFlux(GratuityOut.class)
            .subscribe(out ->
                System.out.println(out.getPercent() + "% gratuity on "
                                    + out.getBillTotal() + " is "
                                    + out.getGratuity()));
        };
    }
}
