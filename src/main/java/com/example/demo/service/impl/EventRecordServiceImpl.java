package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.service.EventRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventRecordServiceImpl implements EventRecordService {

    private final EventRecordRepository eventRecordRepository;

    @Autowired
    public EventRecordServiceImpl(EventRecordRepository eventRecordRepository) {
        this.eventRecordRepository = eventRecordRepository;
    }

    @Override
    public EventRecord saveEvent(EventRecord event) {
        return eventRecordRepository.save(event);
    }

    @Override
    public EventRecord updateEvent(Long id, EventRecord event) {
        EventRecord existing = eventRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        existing.setEventCode(event.getEventCode());
        existing.setEventName(event.getEventName());
        existing.setVenue(event.getVenue());
        existing.setActive(event.isActive());
        existing.setBasePrice(event.getBasePrice());
        return eventRecordRepository.save(existing);
    }

    @Override
    public EventRecord getEventByCode(String eventCode) {
        return eventRecordRepository.findByEventCode(eventCode)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public List<EventRecord> getAllEvents() {
        return eventRecordRepository.findAll();
    }
}
