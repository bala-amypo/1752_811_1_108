package com.example.demo.controller;

import com.example.demo.model.EventRecord;
import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.service.impl.SeatInventoryServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seats")
public class SeatInventoryController {

    private final SeatInventoryServiceImpl seatService;
    private final EventRecordRepository eventRepo;

    public SeatInventoryController(SeatInventoryServiceImpl seatService, EventRecordRepository eventRepo) {
        this.seatService = seatService;
        this.eventRepo = eventRepo;
    }

    @PostMapping("/create")
    public SeatInventoryRecord createInventory(@RequestParam Long eventId, @RequestParam int totalSeats) {
        EventRecord event = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found: " + eventId));

        SeatInventoryRecord inventory = new SeatInventoryRecord(event, totalSeats);
        return seatService.saveInventory(inventory);
    }

    @GetMapping("/{eventId}")
    public int getAvailableSeats(@PathVariable Long eventId) {
        EventRecord event = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found: " + eventId));

        return seatService.calculateAvailableSeats(event);
    }

    @PostMapping("/sell")
    public String sellSeats(@RequestParam Long eventId, @RequestParam int seats) {
        EventRecord event = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found: " + eventId));

        seatService.updateRemainingSeats(event, seats);
        return "Sold " + seats + " seats for event " + event.getName();
    }
}
