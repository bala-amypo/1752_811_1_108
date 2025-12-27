package com.example.demo.controller;

import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.service.SeatInventoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@Tag(name = "SeatInventoryController", description = "Manage Seat Inventories")
public class SeatInventoryController {

    private final SeatInventoryService seatInventoryService;

    public SeatInventoryController(SeatInventoryService seatInventoryService) {
        this.seatInventoryService = seatInventoryService;
    }

    @PostMapping
    public ResponseEntity<SeatInventoryRecord> createInventory(@RequestBody SeatInventoryRecord inventory) {
        return ResponseEntity.ok(seatInventoryService.createInventory(inventory));
    }

    @PutMapping("/{eventId}/remaining")
    public ResponseEntity<Void> updateRemaining(@PathVariable Long eventId, @RequestParam Integer remainingSeats) {
        seatInventoryService.updateRemainingSeats(eventId, remainingSeats);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<SeatInventoryRecord> getByEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(seatInventoryService.getInventoryByEvent(eventId));
    }

    @GetMapping
    public ResponseEntity<List<SeatInventoryRecord>> getAllInventories() {
        return ResponseEntity.ok(seatInventoryService.getAllInventories());
    }
}
