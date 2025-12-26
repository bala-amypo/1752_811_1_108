package com.example.demo.service.impl;

import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.repository.SeatInventoryRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class SeatInventoryServiceImpl {

    private final SeatInventoryRecordRepository inventoryRepo;

    public SeatInventoryServiceImpl(SeatInventoryRecordRepository inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public int calculateAvailableSeats(Long eventId) {
        SeatInventoryRecord inventory = inventoryRepo.findByEventId(eventId);

        if (inventory == null) {
            throw new RuntimeException("Seat inventory not found for event: " + eventId);
        }

        int remainingSeats = inventory.getRemainingSeats();
        int totalSeats = inventory.getTotalSeats();
        return Math.min(remainingSeats, totalSeats);
    }

    public void updateRemainingSeats(Long eventId, int seatsSold) {
        SeatInventoryRecord inventory = inventoryRepo.findByEventId(eventId);

        if (inventory == null) {
            throw new RuntimeException("Seat inventory not found for event: " + eventId);
        }

        int updatedRemaining = inventory.getRemainingSeats() - seatsSold;
        inventory.setRemainingSeats(updatedRemaining);
        inventoryRepo.save(inventory);
    }
}
