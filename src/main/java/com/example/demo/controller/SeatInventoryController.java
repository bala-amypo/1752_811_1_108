package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.model.SeatInventory;
import com.example.demo.repository.SeatInventoryRepository;
import com.example.demo.service.SeatInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<SeatInventory> existing = seatInventoryRepository.findById(id);
        if (existing.isPresent()) {
            SeatInventory updated = existing.get();
            updated.setSeatType(seatInventory.getSeatType());
            updated.setQuantity(seatInventory.getQuantity());
            updated.setEvent(seatInventory.getEvent());
            return seatInventoryRepository.save(updated);
        }
        return null;
    }

    @Override
    public void deleteSeatInventory(Long id) {
        seatInventoryRepository.deleteById(id);
    }

    @Override
    public List<SeatInventory> getAllSeatsByEvent(EventRecord event) {
        // Use event.getId() instead of getEventId()
        return seatInventoryRepository.findByEventId(event.getId());
    }

    @Override
    public Optional<SeatInventory> getSeatInventoryById(Long id) {
        return seatInventoryRepository.findById(id);
    }
}
