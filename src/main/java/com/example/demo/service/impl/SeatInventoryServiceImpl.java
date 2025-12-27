package com.example.demo.service.impl;

import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.repository.SeatInventoryRecordRepository;
import com.example.demo.service.SeatInventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatInventoryServiceImpl implements SeatInventoryService {

    private final SeatInventoryRecordRepository inventoryRepo;

    public SeatInventoryServiceImpl(SeatInventoryRecordRepository inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    @Override
    public List<SeatInventoryRecord> getAllInventories() {
        return inventoryRepo.findAll();
    }

    @Override
    public List<SeatInventoryRecord> getByEventId(Long eventId) {
        return inventoryRepo.findByEventId(eventId);
    }
}
