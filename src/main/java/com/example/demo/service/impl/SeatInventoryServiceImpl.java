package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.repository.SeatInventoryRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class SeatInventoryServiceImpl {

    private final SeatInventoryRecordRepository inventoryRepo;

    public SeatInventoryServiceImpl(SeatInventoryRecordRepository inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public SeatInventoryRecord saveInventory(SeatInventoryRecord inventory) {
        return inventoryRepo.save(inventory);
    }

    public int calculateAvailableSeats(EventRecord event) {
        SeatInventoryRecord inventory = inventoryRepo.findByEvent(event)
                .orElseThrow(() -> new RuntimeException("Seat inventory not found for event: " + event.getEventId()));
        return Math.min(inventory.getRemainingSeats(), inventory.getTotalSeats());
    }

    public void updateRemainingSeats(EventRecord event, int seatsSold) {
        SeatInventoryRecord inventory = inventoryRepo.findByEvent(event)
                .orElseThrow(() -> new RuntimeException("Seat inventory not found for event: " + event.getEventId()));
        inventory.setRemainingSeats(inventory.getRemainingSeats() - seatsSold);
        inventoryRepo.save(inventory);
    }
}
