package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventRecordServiceImpl {

    private final EventRecordRepository eventRepo;

    public EventRecordServiceImpl(EventRecordRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    public EventRecord saveEvent(EventRecord event) {
        return eventRepo.save(event);
    }

    public Optional<EventRecord> getEventByCode(String code) {
        return eventRepo.findByEventCode(code);
    }

    public void updateEventStatus(Long eventId, boolean active) {
        EventRecord event = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found: " + eventId));
        event.setActive(active);
        eventRepo.save(event);
    }

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
