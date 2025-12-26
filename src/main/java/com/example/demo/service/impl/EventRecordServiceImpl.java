package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.service.EventRecordService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EventRecordServiceImpl implements EventRecordService {

    private final EventRecordRepository eventRepo;

    public EventRecordServiceImpl(EventRecordRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public EventRecord saveEvent(EventRecord event) {
        return eventRepo.save(event);
    }

    @Override
    public Optional<EventRecord> getEventByCode(String code) {
        return eventRepo.findByEventCode(code);
    }

    @Override
    public void updateEventStatus(Long eventId, boolean active) {
        EventRecord event = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found: " + eventId));
        event.setActive(active);
        eventRepo.save(event);
    }

    @Override
    public EventRecord updateEvent(Long eventId, EventRecord updatedEvent) {
        EventRecord existingEvent = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found: " + eventId));
        existingEvent.setEventName(updatedEvent.getEventName());
        existingEvent.setVenue(updatedEvent.getVenue());
        existingEvent.setBasePrice(updatedEvent.getBasePrice());
        existingEvent.setActive(updatedEvent.isActive());
        return eventRepo.save(existingEvent);
    }
}
