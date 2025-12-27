package com.example.demo.service.impl;

import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.model.EventRecord;
import com.example.demo.repository.SeatInventoryRecordRepository;
import com.example.demo.service.SeatInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeatInventoryServiceImpl implements SeatInventoryService {

    @Autowired
    private SeatInventoryRecordRepository inventoryRepository;

    @Override
    public SeatInventoryRecord createInventory(SeatInventoryRecord inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<SeatInventoryRecord> getAllInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public List<SeatInventoryRecord> getInventoriesByEvent(EventRecord event) {
        return inventoryRepository.findByEvent(event);
    }
}
