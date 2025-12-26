package com.example.demo.service;

import com.example.demo.model.EventRecord;
import java.util.List;

public interface EventRecordService {

    EventRecord updateEventStatus(Long id, boolean active);

    List<EventRecord> getAllEvents();
}
