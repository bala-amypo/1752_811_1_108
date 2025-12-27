package com.example.demo.service;

import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.model.EventRecord;
import java.util.List;

public interface SeatInventoryService {
    SeatInventoryRecord createInventory(SeatInventoryRecord inventory);
    List<SeatInventoryRecord> getAllInventories();
    List<SeatInventoryRecord> getInventoriesByEvent(EventRecord event);
}
