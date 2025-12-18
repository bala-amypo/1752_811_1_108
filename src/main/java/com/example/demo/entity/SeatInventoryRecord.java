@Entity
public class SeatInventoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;
    private Integer totalSeats;
    private Integer remainingSeats;

    private LocalDateTime updatedAt = LocalDateTime.now();

    // getters & setters
}
