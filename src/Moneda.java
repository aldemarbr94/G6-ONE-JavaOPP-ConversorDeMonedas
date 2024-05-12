import java.util.Map;

public record Moneda(String time_last_update_utc,
                     String time_next_update_utc,
                     Map<String, Double> conversion_rates) {
}
