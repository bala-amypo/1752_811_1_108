package com.example.demo.controller;

import com.example.demo.model.DynamicPriceRecord;
import com.example.demo.service.DynamicPricingEngineService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dynamic-pricing")
@Tag(name = "DynamicPricingController", description = "Compute Dynamic Prices")
public class DynamicPricingController {

    private final DynamicPricingEngineService dynamicPricingEngineService;

    public DynamicPricingController(DynamicPricingEngineService dynamicPricingEngineService) {
        this.dynamicPricingEngineService = dynamicPricingEngineService;
    }

    @PostMapping("/compute/{eventId}")
    public ResponseEntity<DynamicPriceRecord> computePrice(@PathVariable Long eventId) {
        return ResponseEntity.ok(dynamicPricingEngineService.computeDynamicPrice(eventId));
    }

    @GetMapping("/latest/{eventId}")
    public ResponseEntity<DynamicPriceRecord> getLatestPrice(@PathVariable Long eventId) {
        return ResponseEntity.ok(dynamicPricingEngineService.getLatestPrice(eventId));
    }

    @GetMapping("/history/{eventId}")
    public ResponseEntity<List<DynamicPriceRecord>> getPriceHistory(@PathVariable Long eventId) {
        return ResponseEntity.ok(dynamicPricingEngineService.getPriceHistory(eventId));
    }

    @GetMapping
    public ResponseEntity<List<DynamicPriceRecord>> getAllComputedPrices() {
        return ResponseEntity.ok(dynamicPricingEngineService.getAllComputedPrices());
    }
}
