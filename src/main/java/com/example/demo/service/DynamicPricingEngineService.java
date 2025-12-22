package com.example.demo.service;

import com.example.demo.entity.DynamicPriceRecord;
import java.util.List;

public interface DynamicPricingEngineService {

    DynamicPriceRecord calculatePrice(Long eventId);

    List<DynamicPriceRecord> getPriceHistory(Long eventId);
}
