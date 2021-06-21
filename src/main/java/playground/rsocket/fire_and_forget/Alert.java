package playground.rsocket.fire_and_forget;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force=true)
public class Alert {

    private Level level;
    private String orderedBy;
    private Instant orderedAt;

    public static enum Level {
        YELLOW, ORANGE, RED, BLACK
    }
}
