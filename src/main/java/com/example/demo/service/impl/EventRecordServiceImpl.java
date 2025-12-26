package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.service.EventRecordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventRecordServiceImpl implements EventRecordService {

    @Override
    public EventRecord updateEventStatus(Long id, boolean active) {
        EventRecord event = new EventRecord();
        event.setId(id);
        event.setActive(active);
        return event;
    }

    @Override
    public List<EventRecord> getAllEvents() {
        // Minimal stub to satisfy compiler
        return new ArrayList<>();
    }
}
