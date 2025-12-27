package com.example.demo.controller;

import com.example.demo.model.DynamicPriceRecord;
import com.example.demo.service.DynamicPricingEngineService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pricing")
public class DynamicPricingController {

    private final DynamicPricingEngineService service;

    public DynamicPricingController(DynamicPricingEngineService service) {
        this.service = service;
    }

    @GetMapping("/latest/{eventId}")
    public DynamicPriceRecord getLatestPrice(@PathVariable Long eventId) {
        return service.computeDynamicPrice(eventId);
    }
}
