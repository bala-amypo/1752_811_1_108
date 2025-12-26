package com.example.demo.service;

import com.example.demo.model.SeatInventory;

import java.util.List;

public interface SeatInventoryService {
    SeatInventory createSeatInventory(SeatInventory seatInventory);
    SeatInventory updateSeatInventory(Long id, SeatInventory seatInventory);
    void deleteSeatInventory(Long id);
    List<SeatInventory> getAllSeatsByEventId(Long eventId);
}
