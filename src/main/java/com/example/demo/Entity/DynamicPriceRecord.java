@Entity
public class DynamicPriceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;
    private double computedPrice;
    private String appliedRuleCodes;

    private LocalDateTime computedAt = LocalDateTime.now();

    // getters & setters
}
