package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.repository.SeatInventoryRecordRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeatInventoryServiceImpl {

    private final SeatInventoryRecordRepository inventoryRepo;

    // Constructor
    public SeatInventoryServiceImpl(SeatInventoryRecordRepository inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    // Save inventory
    public SeatInventoryRecord saveInventory(SeatInventoryRecord inventory) {
        return inventoryRepo.save(inventory);
    }

    // Calculate available seats
    public int calculateAvailableSeats(EventRecord event) {
        Optional<SeatInventoryRecord> optionalInventory = inventoryRepo.findByEvent(event);
        SeatInventoryRecord inventory = optionalInventory
                .orElseThrow(() -> new RuntimeException("Seat inventory not found for event: " + event.getEventId()));

        return Math.min(inventory.getRemainingSeats(), inventory.getTotalSeats());
    }

    // Update remaining seats
    public void updateRemainingSeats(EventRecord event, int seatsSold) {
        Optional<SeatInventoryRecord> optionalInventory = inventoryRepo.findByEvent(event);
        SeatInventoryRecord inventory = optionalInventory
                .orElseThrow(() -> new RuntimeException("Seat inventory not found for event: " + event.getEventId()));

        int updatedRemaining = inventory.getRemainingSeats() - seatsSold;
        inventory.setRemainingSeats(updatedRemaining);
        inventoryRepo.save(inventory);
    }
}
