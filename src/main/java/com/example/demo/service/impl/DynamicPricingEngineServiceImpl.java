package com.example.demo.service.impl;

import com.example.demo.model.DynamicPriceRecord;
import com.example.demo.repository.DynamicPriceRecordRepository;
import com.example.demo.service.DynamicPricingEngineService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DynamicPricingEngineServiceImpl implements DynamicPricingEngineService {

    private final DynamicPriceRecordRepository repository;

    public DynamicPricingEngineServiceImpl(DynamicPriceRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DynamicPriceRecord computeDynamicPrice(Long eventId) {
        DynamicPriceRecord record = new DynamicPriceRecord();
        record.setEventId(eventId);
        record.setPrice(100.0);
        record.setComputedAt(LocalDateTime.now());
        return repository.save(record);
    }

    @Override
    public DynamicPriceRecord getLatestPrice(Long eventId) {
        List<DynamicPriceRecord> list = repository.findByEventId(eventId);
        return list.isEmpty() ? null : list.get(list.size() - 1);
    }

    @Override
    public List<DynamicPriceRecord> getAllComputedPrices() {
        return repository.findAll();
    }
}
