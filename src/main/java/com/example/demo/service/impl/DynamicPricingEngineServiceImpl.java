package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DynamicPricingEngineService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

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

        if (!Boolean.TRUE.equals(event.getActive())) {
            throw new BadRequestException("Event is not active");
        }

        SeatInventoryRecord inventory = inventoryRepo.findByEventId(eventId)
                .orElseThrow(() -> new NotFoundException("Seat inventory not found"));

        double finalPrice = event.getBasePrice();
        List<PricingRule> activeRules = ruleRepo.findByActiveTrue();

        long daysBeforeEvent =
                ChronoUnit.DAYS.between(LocalDate.now(), event.getEventDate());

        List<PricingRule> appliedRules = activeRules.stream()
                .filter(r ->
                        inventory.getRemainingSeats() >= r.getMinRemainingSeats() &&
                        inventory.getRemainingSeats() <= r.getMaxRemainingSeats() &&
                        daysBeforeEvent <= r.getDaysBeforeEvent()
                )
                .collect(Collectors.toList());

        if (!appliedRules.isEmpty()) {
            finalPrice *= appliedRules.get(0).getPriceMultiplier();
        }

        DynamicPriceRecord record = new DynamicPriceRecord();
        record.setEventId(eventId);
        record.setComputedPrice(finalPrice);
        record.setAppliedRuleCodes(
                appliedRules.stream()
                        .map(PricingRule::getRuleCode)
                        .collect(Collectors.joining(","))
        );

        DynamicPriceRecord saved = priceRepo.save(record);

        priceRepo.findFirstByEventIdOrderByComputedAtDesc(eventId)
                .ifPresent(prev -> {
                    if (!prev.getComputedPrice().equals(finalPrice)) {
                        PriceAdjustmentLog log = new PriceAdjustmentLog();
                        log.setEventId(eventId);
                        log.setOldPrice(prev.getComputedPrice());
                        log.setNewPrice(finalPrice);
                        logRepo.save(log);
                    }
                });

        return saved;
    }

    @Override
    public List<DynamicPriceRecord> getPriceHistory(Long eventId) {
        return priceRepo.findByEventIdOrderByComputedAtDesc(eventId);
    }

    @Override
    public List<DynamicPriceRecord> getAllComputedPrices() {
        return priceRepo.findAll();
    }
}
