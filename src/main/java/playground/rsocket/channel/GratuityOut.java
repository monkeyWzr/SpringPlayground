package playground.rsocket.channel;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force=true)
public class GratuityOut {
    private BigDecimal billTotal;
    private int percent;
    private BigDecimal gratuity;
}
