@Service
public class SeatInventoryServiceImpl implements SeatInventoryService {

    private final SeatInventoryRecordRepository inventoryRepo;

    public SeatInventoryServiceImpl(SeatInventoryRecordRepository inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    @Override
    public List<SeatInventoryRecord> getAllInventories() {
        return inventoryRepo.findAll();
    }

    @Override
    public List<SeatInventoryRecord> getInventoryByEvent(Long eventId) {
        return inventoryRepo.findByEventId(eventId);
    }
}
