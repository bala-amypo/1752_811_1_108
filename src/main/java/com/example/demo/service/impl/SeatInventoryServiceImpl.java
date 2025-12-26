package com.example.demo.service.impl;

import com.example.demo.model.SeatInventory;
import com.example.demo.model.EventRecord;
import com.example.demo.repository.SeatInventoryRepository;
import com.example.demo.service.SeatInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatInventoryServiceImpl implements SeatInventoryService {

    private final SeatInventoryRepository seatInventoryRepository;

    @Autowired
    public SeatInventoryServiceImpl(SeatInventoryRepository seatInventoryRepository) {
        this.seatInventoryRepository = seatInventoryRepository;
    }

    @Override
    public SeatInventory saveInventory(SeatInventory inventory) {
        return seatInventoryRepository.save(inventory);
    }

    @Override
    public int calculateAvailableSeats(EventRecord event) {
        SeatInventory inventory = getInventoryByEvent(event);
        return inventory != null ? inventory.getRemainingSeats() : 0;
    }

    @Override
    public void updateRemainingSeats(EventRecord event, int remainingSeats) {
        SeatInventory inventory = getInventoryByEvent(event);
        if (inventory != null) {
            inventory.setRemainingSeats(remainingSeats);
            seatInventoryRepository.save(inventory);
        }
    }

    @Override
    public SeatInventory getInventoryByEvent(EventRecord event) {
        return seatInventoryRepository.findByEvent(event).orElse(null);
    }
}
