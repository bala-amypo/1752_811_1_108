package com.example.demo.service.impl;

import com.example.demo.model.PriceAdjustmentLog;
import com.example.demo.repository.PriceAdjustmentLogRepository;
import com.example.demo.service.PriceAdjustmentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PriceAdjustmentLogServiceImpl implements PriceAdjustmentLogService {

    @Autowired
    private PriceAdjustmentLogRepository logRepository;

    @Override
    public PriceAdjustmentLog logAdjustment(PriceAdjustmentLog log) {
        return logRepository.save(log);
    }

    @Override
    public List<PriceAdjustmentLog> getAllAdjustments() {
        return logRepository.findAll();
    }

    @Override
    public PriceAdjustmentLog getAdjustmentById(Long id) {
        return logRepository.findById(id).orElse(null);
    }
}
