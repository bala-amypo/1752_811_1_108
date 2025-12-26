package com.example.demo.service;

import com.example.demo.model.EventRecord;
import java.util.Optional;

public interface EventRecordService {
    EventRecord saveEvent(EventRecord event);
    Optional<EventRecord> getEventByCode(String code);
    void updateEventStatus(Long eventId, boolean active);
    EventRecord updateEvent(Long eventId, EventRecord updatedEvent);
}
