package com.example.demo.controller;

import com.example.demo.model.SeatInventory;
import com.example.demo.model.EventRecord;
import com.example.demo.service.SeatInventoryService;
import com.example.demo.service.EventRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seats")
public class SeatInventoryController {

    private final SeatInventoryService seatService;
    private final EventRecordService eventService;

    @Autowired
    public SeatInventoryController(SeatInventoryService seatService, EventRecordService eventService) {
        this.seatService = seatService;
        this.eventService = eventService;
    }

    @PostMapping("/{eventCode}")
    public SeatInventory createInventory(@PathVariable String eventCode, @RequestBody SeatInventory inventory) {
        EventRecord event = eventService.getEventByCode(eventCode);
        inventory.setEvent(event);
        return seatService.saveInventory(inventory);
    }

    @GetMapping("/{eventCode}")
    public int getAvailableSeats(@PathVariable String eventCode) {
        EventRecord event = eventService.getEventByCode(eventCode);
        return seatService.calculateAvailableSeats(event);
    }
}
