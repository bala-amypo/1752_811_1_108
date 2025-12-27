package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.repository.SeatInventoryRecordRepository;
import com.example.demo.service.SeatInventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatInventoryServiceImpl implements SeatInventoryService {

    private final SeatInventoryRecordRepository inventoryRepo;
    private final EventRecordRepository eventRepo;

    public SeatInventoryServiceImpl(
            SeatInventoryRecordRepository inventoryRepo,
            EventRecordRepository eventRepo) {
        this.inventoryRepo = inventoryRepo;
        this.eventRepo = eventRepo;
    }

    public SeatInventoryRecord createInventory(SeatInventoryRecord record) {
        return inventoryRepo.save(record);
    }

    public SeatInventoryRecord updateRemainingSeats(Long id, Integer remaining) {
        SeatInventoryRecord record =
                inventoryRepo.findById(id).orElse(null);
        if (record != null) {
            record.setRemainingSeats(remaining);
            return inventoryRepo.save(record);
        }
        return null;
    }

    @Override
public List<SeatInventoryRecord> getInventoryByEvent(Long eventId) {
    return inventoryRepo.findByEventId(eventId);
}


}
