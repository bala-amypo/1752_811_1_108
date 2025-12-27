package com.example.demo.service;

import java.math.BigDecimal;

public interface DynamicPricingEngineService {
    BigDecimal getLatestPrice(Long eventId);
}
