package com.example.demo.controller;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventRecordController {

    @Autowired
    private EventRecordRepository repository;

    @PostMapping
    public EventRecord createEvent(@RequestBody EventRecord event) {
        return repository.save(event);
    }

    @GetMapping
    public List<EventRecord> getAllEvents() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public EventRecord getEventById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public EventRecord updateEvent(@PathVariable Long id, @RequestBody EventRecord event) {
        EventRecord existing = repository.findById(id).orElseThrow();
        existing.setEventCode(event.getEventCode());
        existing.setEventName(event.getEventName());
        existing.setVenue(event.getVenue());
        existing.setActive(event.isActive());
        existing.setBasePrice(event.getBasePrice());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
