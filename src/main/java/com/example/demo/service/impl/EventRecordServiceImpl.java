package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EventRecordServiceImpl {

    private final EventRecordRepository eventRecordRepository;

    public EventRecordServiceImpl(EventRecordRepository eventRecordRepository) {
        this.eventRecordRepository = eventRecordRepository;
    }
    public List<EventRecord> getAllEvents() {
    return eventRecordRepository.findAll();
}


    public EventRecord createEvent(String name) {
        EventRecord event = new EventRecord(name);
        return eventRecordRepository.save(event);
    }

    public EventRecord getActiveEventById(Long id) {
        return eventRecordRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new RuntimeException("Event not found or inactive: " + id));
    }
}
