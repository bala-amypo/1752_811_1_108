package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.service.EventRecordService;
import org.springframework.stereotype.Service;

@Service
public class EventRecordServiceImpl implements EventRecordService {

    @Override
    public EventRecord updateEventStatus(Long id, boolean active) {
        // Minimal implementation to satisfy compiler
        EventRecord event = new EventRecord();
        event.setId(id);
        event.setActive(active);
        return event;
    }
}
