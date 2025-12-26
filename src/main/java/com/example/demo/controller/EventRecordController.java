package com.example.demo.controller;

import com.example.demo.model.EventRecord;
import com.example.demo.service.impl.EventRecordServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventRecordController {

    private final EventRecordServiceImpl eventService;

    public EventRecordController(EventRecordServiceImpl eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public EventRecord createEvent(@RequestParam String name) {
        return eventService.createEvent(name);
    }

    @GetMapping("/{id}")
    public EventRecord getEvent(@PathVariable Long id) {
        return eventService.getActiveEventById(id);
    }

    @GetMapping
    public List<EventRecord> getAllEvents() {
        // Optional: fetch all events (for testing)
        return eventService.getAllEvents();
    }
}
