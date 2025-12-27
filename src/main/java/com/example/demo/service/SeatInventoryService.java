package com.example.demo.service;

import com.example.demo.model.SeatInventoryRecord;
import java.util.List;

public interface SeatInventoryService {

    List<SeatInventoryRecord> getAllInventories();

    List<SeatInventoryRecord> getByEventId(Long eventId);
}
