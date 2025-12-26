package com.example.demo.service.impl;

import com.example.demo.repository.SeatInventoryRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class DynamicPricingEngineServiceImpl {

    private final SeatInventoryRecordRepository seatInventoryRecordRepository;

    public DynamicPricingEngineServiceImpl(SeatInventoryRecordRepository seatInventoryRecordRepository) {
        this.seatInventoryRecordRepository = seatInventoryRecordRepository;
    }

    // your service methods
}
