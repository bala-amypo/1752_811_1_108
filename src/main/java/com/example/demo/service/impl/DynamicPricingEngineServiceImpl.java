package com.example.demo.service.impl;

import com.example.demo.service.DynamicPricingEngineService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class DynamicPricingEngineServiceImpl implements DynamicPricingEngineService {

    @Override
    public BigDecimal getLatestPrice(Long eventId) {
        // Dummy implementation
        return BigDecimal.valueOf(100.0);
    }
}
