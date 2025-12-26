package com.example.demo.service;

import com.example.demo.model.SeatInventory;
import com.example.demo.model.EventRecord;

public interface SeatInventoryService {
    SeatInventory saveInventory(SeatInventory inventory);
    int calculateAvailableSeats(EventRecord event);
    void updateRemainingSeats(EventRecord event, int remainingSeats);
    SeatInventory getInventoryByEvent(EventRecord event);
}
