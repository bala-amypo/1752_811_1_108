@Entity
public class PriceAdjustmentLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;
    private double oldPrice;
    private double newPrice;
    private String reason;

    private LocalDateTime changedAt = LocalDateTime.now();

    // getters & setters
}
