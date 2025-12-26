package com.example.demo.service;

import com.example.demo.model.EventRecord;

import java.util.List;
import java.util.Optional;

public interface EventRecordService {
    EventRecord createEvent(EventRecord event);
    Optional<EventRecord> getEventById(Long id);
    List<EventRecord> getAllEvents();
    EventRecord updateEvent(Long id, EventRecord updatedEvent);
    void deleteEvent(Long id);
}
