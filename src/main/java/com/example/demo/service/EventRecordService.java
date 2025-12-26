package com.example.demo.service;

import com.example.demo.model.EventRecord;
import java.util.List;

public interface EventRecordService {
    EventRecord saveEvent(EventRecord event);
    EventRecord updateEvent(Long id, EventRecord event);
    EventRecord getEventByCode(String eventCode);
    List<EventRecord> getAllEvents();
}
