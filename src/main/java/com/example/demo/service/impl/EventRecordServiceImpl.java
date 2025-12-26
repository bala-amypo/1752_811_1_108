package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;   // Needed for List
import java.util.Optional; // Needed for Optional

@Service
public class EventRecordServiceImpl {

    private final EventRecordRepository eventRecordRepository;

    public EventRecordServiceImpl(EventRecordRepository eventRecordRepository) {
        this.eventRecordRepository = eventRecordRepository;
    }

    // Create a new event
    public EventRecord createEvent(EventRecord event) {
        // You can set defaults here if needed, e.g., active = true
        event.setActive(true);
        return eventRecordRepository.save(event);
    }

    // Update an existing event
    public EventRecord updateEvent(Long id, EventRecord updatedEvent) {
        Optional<EventRecord> optionalEvent = eventRecordRepository.findById(id);
        if (optionalEvent.isPresent()) {
            EventRecord event = optionalEvent.get();
            event.setName(updatedEvent.getName());
            event.setActive(updatedEvent.isActive());
            return eventRecordRepository.save(event);
        }
        return null; // or throw an exception
    }

    // Get a single event by ID
    public Optional<EventRecord> getEventById(Long id) {
        return eventRecordRepository.findById(id);
    }

    // Get all events
    public List<EventRecord> getAllEvents() {
        return eventRecordRepository.findAll();
    }

    // Delete an event
    public void deleteEvent(Long id) {
        eventRecordRepository.deleteById(id);
    }
}
