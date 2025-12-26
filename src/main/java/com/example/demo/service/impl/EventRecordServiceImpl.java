package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.service.EventRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventRecordServiceImpl implements EventRecordService {

    @Autowired
    private EventRecordRepository eventRecordRepository;

    @Override
    public EventRecord createEvent(EventRecord eventRecord) {
        return eventRecordRepository.save(eventRecord);
    }

    @Override
    public EventRecord updateEvent(Long id, EventRecord eventRecord) {
        Optional<EventRecord> existingEvent = eventRecordRepository.findById(id);
        if (existingEvent.isPresent()) {
            EventRecord e = existingEvent.get();
            e.setEventCode(eventRecord.getEventCode());
            e.setEventName(eventRecord.getEventName());
            e.setVenue(eventRecord.getVenue());
            e.setActive(eventRecord.isActive());
            e.setBasePrice(eventRecord.getBasePrice());
            return eventRecordRepository.save(e);
        }
        return null;
    }

    @Override
    public void deleteEvent(Long id) {
        eventRecordRepository.deleteById(id);
    }

    @Override
    public Optional<EventRecord> getEventById(Long id) {
        return eventRecordRepository.findById(id);
    }

    @Override
    public List<EventRecord> getAllEvents() {
        return eventRecordRepository.findAll();
    }
}
