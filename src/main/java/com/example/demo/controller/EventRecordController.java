package com.example.demo.controller;

import com.example.demo.model.EventRecord;
import com.example.demo.service.EventRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventRecordController {

    private final EventRecordService eventService;

    @Autowired
    public EventRecordController(EventRecordService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public EventRecord createEvent(@RequestBody EventRecord event) {
        return eventService.saveEvent(event);
    }

    @PutMapping("/{id}")
    public EventRecord updateEvent(@PathVariable Long id, @RequestBody EventRecord event) {
        return eventService.updateEvent(id, event);
    }

    @GetMapping("/{eventCode}")
    public EventRecord getEventByCode(@PathVariable String eventCode) {
        return eventService.getEventByCode(eventCode);
    }

    @GetMapping
    public List<EventRecord> getAllEvents() {
        return eventService.getAllEvents();
    }
}
