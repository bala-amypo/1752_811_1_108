package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.repository.SeatInventoryRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class SeatInventoryServiceImpl {

    private final SeatInventoryRecordRepository inventoryRepo;
    public SeatInventoryRecord saveInventory(SeatInventoryRecord inventory) {
    return inventoryRepo.save(inventory);
}


    public SeatInventoryServiceImpl(SeatInventoryRecordRepository inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public int calculateAvailableSeats(EventRecord event) {
        SeatInventoryRecord inventory = inventoryRepo.findByEvent(event)
                .orElseThrow(() -> new RuntimeException("Seat inventory not found for event: " + event.getId()));

        return Math.min(inventory.getRemainingSeats(), inventory.getTotalSeats());
    }

    public void updateRemainingSeats(EventRecord event, int seatsSold) {
        SeatInventoryRecord inventory = inventoryRepo.findByEvent(event)
                .orElseThrow(() -> new RuntimeException("Seat inventory not found for event: " + event.getId()));

        int updatedRemaining = inventory.getRemainingSeats() - seatsSold;
        inventory.setRemainingSeats(updatedRemaining);
        inventoryRepo.save(inventory);
    }
}
