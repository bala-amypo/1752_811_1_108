@Entity
public class EventRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String eventCode;

    private String eventName;
    private String venue;
    private LocalDate eventDate;

    private double basePrice;
    private boolean active;

    private LocalDateTime createdAt = LocalDateTime.now();

    // getters & setters
}
