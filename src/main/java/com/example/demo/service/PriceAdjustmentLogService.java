package com.example.demo.service;

import com.example.demo.model.PriceAdjustmentLog;

import java.util.List;

public interface PriceAdjustmentLogService {

    PriceAdjustmentLog getAdjustmentById(Long id);

    List<PriceAdjustmentLog> getAllAdjustments();

    PriceAdjustmentLog save(PriceAdjustmentLog log);
}
