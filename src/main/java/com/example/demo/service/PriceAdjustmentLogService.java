package com.example.demo.service;

import com.example.demo.model.PriceAdjustmentLog;
import java.util.List;

public interface PriceAdjustmentLogService {

    PriceAdjustmentLog getById(Long id);

    List<PriceAdjustmentLog> getAll();

    PriceAdjustmentLog save(PriceAdjustmentLog log);
}
