package com.example.demo.service.impl;

import com.example.demo.model.DynamicPriceRecord;
import com.example.demo.repository.DynamicPriceRecordRepository;
import com.example.demo.service.DynamicPricingEngineService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DynamicPricingEngineServiceImpl
        implements DynamicPricingEngineService {

    private final DynamicPriceRecordRepository repo;

    public DynamicPricingEngineServiceImpl(
            DynamicPriceRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public DynamicPriceRecord computeDynamicPrice(Long eventId) {
        DynamicPriceRecord record = new DynamicPriceRecord();
        record.setEventId(eventId);
        record.setPrice(100.0);
        record.setComputedAt(LocalDateTime.now());
        return repo.save(record);
    }

    @Override
    public Double getLatestPrice(Long eventId) {
        List<DynamicPriceRecord> history =
                repo.findByEventId(eventId);
        if (history.isEmpty()) return 0.0;
        return history.get(history.size() - 1).getPrice();
    }

    @Override
    public List<DynamicPriceRecord> getPriceHistory(Long eventId) {
        return repo.findByEventId(eventId);
    }

    @Override
    public List<DynamicPriceRecord> getAllComputedPrices() {
        return repo.findAll();
    }
}
