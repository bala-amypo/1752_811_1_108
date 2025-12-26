package com.example.demo.controller;

import com.example.demo.model.SeatInventory;
import com.example.demo.service.SeatInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatInventoryController {

    @Autowired
    private SeatInventoryService seatInventoryService;

    @PostMapping
    public SeatInventory createSeat(@RequestBody SeatInventory seatInventory) {
        return seatInventoryService.createSeatInventory(seatInventory);
    }

    @PutMapping("/{id}")
    public SeatInventory updateSeat(@PathVariable Long id, @RequestBody SeatInventory seatInventory) {
        return seatInventoryService.updateSeatInventory(id, seatInventory);
    }

    @DeleteMapping("/{id}")
    public void deleteSeat(@PathVariable Long id) {
        seatInventoryService.deleteSeatInventory(id);
    }

    @GetMapping("/event/{eventId}")
    public List<SeatInventory> getSeatsByEvent(@PathVariable Long eventId) {
        // You will need to implement a method in your service to fetch by eventId
        return seatInventoryService.getAllSeatsByEventId(eventId);
    }
}
