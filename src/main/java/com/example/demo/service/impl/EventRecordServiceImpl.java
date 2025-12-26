package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.service.EventRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventRecordServiceImpl implements EventRecordService {

    private final EventRecordRepository eventRepo;

    public EventRecordServiceImpl(EventRecordRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public EventRecord createEvent(EventRecord event) {
        return eventRepo.save(event);
    }

    @Override
    public Optional<EventRecord> getEventById(Long eventId) {
        return eventRepo.findById(eventId);
    }

    @Override
    public List<EventRecord> getAllEvents() {
        return eventRepo.findAll();
    }

    @Override
    public EventRecord updateEvent(Long eventId, EventRecord updatedEvent) {
        EventRecord existing = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found: " + eventId));
        existing.setEventName(updatedEvent.getEventName());
        existing.setVenue(updatedEvent.getVenue());
        existing.setBasePrice(updatedEvent.getBasePrice());
        existing.setActive(updatedEvent.isActive());
        return eventRepo.save(existing);
    }

    @Override
    public void updateEventStatus(Long eventId, boolean active) {
        EventRecord existing = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found: " + eventId));
        existing.setActive(active);
        eventRepo.save(existing);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventRepo.deleteById(eventId);
    }

    @Override
    public Optional<EventRecord> getEventByCode(String code) {
        return eventRepo.findByEventCode(code);
    }
}
