package com.example.demo.controller;

import com.example.demo.model.PriceAdjustmentLog;
import com.example.demo.service.PriceAdjustmentLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/price-adjustments")
@Tag(name = "PriceAdjustmentLogController", description = "Manage Price Adjustment Logs")
public class PriceAdjustmentLogController {

    private final PriceAdjustmentLogService priceAdjustmentLogService;

    public PriceAdjustmentLogController(PriceAdjustmentLogService priceAdjustmentLogService) {
        this.priceAdjustmentLogService = priceAdjustmentLogService;
    }

    @PostMapping
    public ResponseEntity<PriceAdjustmentLog> logManually(@RequestBody PriceAdjustmentLog log) {
        return ResponseEntity.ok(priceAdjustmentLogService.logAdjustment(log));
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<PriceAdjustmentLog>> getByEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(priceAdjustmentLogService.getAdjustmentsByEvent(eventId));
    }

    @GetMapping
    public ResponseEntity<List<PriceAdjustmentLog>> getAll() {
        return ResponseEntity.ok(priceAdjustmentLogService.getAllAdjustments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriceAdjustmentLog> getById(@PathVariable Long id) {
        return ResponseEntity.ok(priceAdjustmentLogService.getAdjustmentById(id));
    }
}
