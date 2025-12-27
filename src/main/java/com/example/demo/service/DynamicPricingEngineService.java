package com.example.demo.service;

import com.example.demo.model.DynamicPriceRecord;
import java.util.List;

public interface DynamicPricingEngineService {

    /**
     * Calculate and store latest dynamic price for an event
     */
    DynamicPriceRecord calculatePrice(Long eventId);

    /**
     * Get latest computed price for an event
     */
    DynamicPriceRecord getLatestPrice(Long eventId);

    /**
     * Get all computed prices
     */
    List<DynamicPriceRecord> getAllComputedPrices();
}
