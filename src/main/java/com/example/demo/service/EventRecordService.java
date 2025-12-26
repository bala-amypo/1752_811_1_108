package com.example.demo.service;

import com.example.demo.model.EventRecord;
import java.util.List;
import java.util.Optional;

public interface EventRecordService {

    EventRecord createEvent(EventRecord eventRecord);

    EventRecord updateEvent(Long id, EventRecord eventRecord);

    void deleteEvent(Long id);

    Optional<EventRecord> getEventById(Long id);

    List<EventRecord> getAllEvents();
}
