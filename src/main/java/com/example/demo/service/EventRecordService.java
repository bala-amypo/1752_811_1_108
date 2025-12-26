package com.example.demo.service;

import com.example.demo.model.EventRecord;

import java.util.List;
import java.util.Optional;

public interface EventRecordService {

    EventRecord createEvent(EventRecord event);

    Optional<EventRecord> getEventById(Long eventId);

    List<EventRecord> getAllEvents();

    EventRecord updateEvent(Long eventId, EventRecord updatedEvent);

    void updateEventStatus(Long eventId, boolean active);

    void deleteEvent(Long eventId);

    Optional<EventRecord> getEventByCode(String code);
}
