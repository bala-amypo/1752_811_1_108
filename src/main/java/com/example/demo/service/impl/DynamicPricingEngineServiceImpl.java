@Service
public class DynamicPricingEngineServiceImpl implements DynamicPricingEngineService {

    private final EventRecordRepository eventRepo;
    private final SeatInventoryRecordRepository inventoryRepo;
    private final PricingRuleRepository ruleRepo;
    private final DynamicPriceRecordRepository priceRepo;
    private final PriceAdjustmentLogRepository logRepo;

    public DynamicPricingEngineServiceImpl(
            EventRecordRepository eventRepo,
            SeatInventoryRecordRepository inventoryRepo,
            PricingRuleRepository ruleRepo,
            DynamicPriceRecordRepository priceRepo,
            PriceAdjustmentLogRepository logRepo) {
        this.eventRepo = eventRepo;
        this.inventoryRepo = inventoryRepo;
        this.ruleRepo = ruleRepo;
        this.priceRepo = priceRepo;
        this.logRepo = logRepo;
    }

    @Override
    public DynamicPriceRecord computeDynamicPrice(Long eventId) {

        EventRecord event = eventRepo.findById(eventId)
                .orElseThrow(() -> new NotFoundException("Event not found"));

        if (!event.isActive()) {
            throw new BadRequestException("Event is not active");
        }

        SeatInventoryRecord inventory = inventoryRepo.findByEventId(eventId)
                .orElseThrow(() -> new BadRequestException("Missing inventory"));

        double price = event.getBasePrice();
        if (price <= 0) throw new BadRequestException("Base price must be > 0");

        List<PricingRule> rules = ruleRepo.findByActiveTrue();
        List<String> appliedRules = new ArrayList<>();

        for (PricingRule rule : rules) {
            if (rule.getPriceMultiplier() <= 0) {
                throw new BadRequestException("Multiplier must be > 0");
            }

            if (inventory.getRemainingSeats() >= rule.getMinRemainingSeats()
                    && inventory.getRemainingSeats() <= rule.getMaxRemainingSeats()) {
                price *= rule.getPriceMultiplier();
                appliedRules.add(rule.getRuleCode());
            }
        }

        DynamicPriceRecord record = new DynamicPriceRecord();
        record.setEventId(eventId);
        record.setComputedPrice(price);
        record.setAppliedRuleCodes(String.join(",", appliedRules));

        priceRepo.save(record);

        if (price != event.getBasePrice()) {
            PriceAdjustmentLog log = new PriceAdjustmentLog();
            log.setEventId(eventId);
            log.setOldPrice(event.getBasePrice());
            log.setNewPrice(price);
            log.setReason("Dynamic pricing applied");
            logRepo.save(log);
        }

        return record;
    }

    @Override
    public List<DynamicPriceRecord> getPriceHistory(Long eventId) {
        return priceRepo.findByEventId(eventId);
    }

    @Override
    public DynamicPriceRecord getLatestPrice(Long eventId) {
        return priceRepo.findByEventId(eventId)
                .stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new NotFoundException("No price found"));
    }

    @Override
    public List<DynamicPriceRecord> getAllComputedPrices() {
        return priceRepo.findAll();
    }
}