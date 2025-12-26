package com.example.demo.service.impl;

import com.example.demo.model.SeatInventory;
import com.example.demo.repository.SeatInventoryRepository;
import com.example.demo.service.SeatInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatInventoryServiceImpl implements SeatInventoryService {

    @Autowired
    private SeatInventoryRepository seatInventoryRepository;

    @Override
    public SeatInventory createSeatInventory(SeatInventory seatInventory) {
        return seatInventoryRepository.save(seatInventory);
    }

    @Override
    public SeatInventory updateSeatInventory(Long id, SeatInventory seatInventory) {
        SeatInventory existing = seatInventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        existing.setSeatNumber(seatInventory.getSeatNumber());
        existing.setBooked(seatInventory.isBooked());
        existing.setEventId(seatInventory.getEventId());
        return seatInventoryRepository.save(existing);
    }

    @Override
    public void deleteSeatInventory(Long id) {
        seatInventoryRepository.deleteById(id);
    }

    @Override
    public List<SeatInventory> getAllSeatsByEventId(Long eventId) {
        return seatInventoryRepository.findByEventId(eventId);
    }
}
