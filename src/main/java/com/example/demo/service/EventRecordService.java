package com.example.demo.service;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventRecordService {

    @Autowired
    private EventRecordRepository eventRecordRepository;

    // Create or update an event
    public EventRecord saveEvent(EventRecord eventRecord) {
        return eventRecordRepository.save(eventRecord);
    }

    // Get all events
    public List<EventRecord> getAllEvents() {
        return eventRecordRepository.findAll();
    }

    // Get event by ID
    public Optional<EventRecord> getEventById(Long id) {
        return eventRecordRepository.findById(id);
    }

    // Get event by code
    public Optional<EventRecord> getEventByCode(String eventCode) {
        return eventRecordRepository.findByEventCode(eventCode);
    }

    // Delete event by ID
    public void deleteEvent(Long id) {
        eventRecordRepository.deleteById(id);
    }

    // Check if eventCode exists
    public boolean existsByEventCode(String eventCode) {
        return eventRecordRepository.existsByEventCode(eventCode);
    }
}
