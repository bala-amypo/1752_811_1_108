package com.example.demo.controller;

import com.example.demo.model.EventRecord;
import com.example.demo.service.EventRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@Tag(name = "EventRecordController", description = "Manage Events")
public class EventRecordController {

    private final EventRecordService eventRecordService;

    public EventRecordController(EventRecordService eventRecordService) {
        this.eventRecordService = eventRecordService;
    }

    @PostMapping
    public ResponseEntity<EventRecord> createEvent(@RequestBody EventRecord event) {
        return ResponseEntity.ok(eventRecordService.createEvent(event));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventRecord> getEvent(@PathVariable Long id) {
        return ResponseEntity.ok(eventRecordService.getEventById(id));
    }

    @GetMapping
    public ResponseEntity<List<EventRecord>> getAllEvents() {
        return ResponseEntity.ok(eventRecordService.getAllEvents());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        eventRecordService.updateEventStatus(id, active);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/lookup/{eventCode}")
    public ResponseEntity<EventRecord> getEventByCode(@PathVariable String eventCode) {
        return ResponseEntity.ok(eventRecordService.getEventByCode(eventCode));
    }
}
