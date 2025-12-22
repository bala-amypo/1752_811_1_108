package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.DynamicPriceRecord;

public interface DynamicPricingEngineService {

    DynamicPriceRecord calculatePrice(Long eventId);

    List<DynamicPriceRecord> getPriceHistory(Long eventId);
}
