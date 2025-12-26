package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.repository.SeatInventoryRecordRepository;
import com.example.demo.service.SeatInventoryService;

public class SeatInventoryServiceImpl implements SeatInventoryService {

    private final SeatInventoryRecordRepository inventoryRepo;
    private final EventRecordRepository eventRepo;

    public SeatInventoryServiceImpl(SeatInventoryRecordRepository inventoryRepo,
                                    EventRecordRepository eventRepo) {
        this.inventoryRepo = inventoryRepo;
        this.eventRepo = eventRepo;
    }

    @Override
    public SeatInventoryRecord createInventory(SeatInventoryRecord inventory) {

        eventRepo.findById(inventory.getEventId())
                .orElseThrow(() -> new NotFoundException("Event not found"));

        if (inventory.getRemainingSeats() > inventory.getTotalSeats()) {
            throw new BadRequestException("Remaining seats cannot exceed total seats");
        }

        return inventoryRepo.save(inventory);
    }

    @Override
    public SeatInventoryRecord getInventoryByEvent(Long eventId) {
        return inventoryRepo.findByEventId(eventId)
                .orElseThrow(() -> new NotFoundException("Seat inventory not found"));
    }
}
