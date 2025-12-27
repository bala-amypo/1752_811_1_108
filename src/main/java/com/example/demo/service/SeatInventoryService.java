package com.example.demo.service;

import com.example.demo.model.SeatInventoryRecord;
import java.util.List;

public interface SeatInventoryService {

    SeatInventoryRecord save(SeatInventoryRecord record);

    List<SeatInventoryRecord> getAllInventories();

    List<SeatInventoryRecord> getInventoryByEvent(Long eventId);
}
