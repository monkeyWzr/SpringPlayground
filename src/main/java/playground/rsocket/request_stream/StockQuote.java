package playground.rsocket.request_stream;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force=true)
public class StockQuote {
    private String symbol;
    private BigDecimal price;
    private Instant timestamp;
}
