package com.example.demo.controller;

import com.example.demo.model.PriceAdjustmentLog;
import com.example.demo.service.PriceAdjustmentLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/price-adjustments")
public class PriceAdjustmentLogController {

    private final PriceAdjustmentLogService service;

    public PriceAdjustmentLogController(PriceAdjustmentLogService service) {
        this.service = service;
    }

    @GetMapping
    public List<PriceAdjustmentLog> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PriceAdjustmentLog getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public PriceAdjustmentLog create(@RequestBody PriceAdjustmentLog log) {
        return service.save(log);
    }
}
