package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.service.EventRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventRecordServiceImpl implements EventRecordService {

    private final EventRecordRepository eventRecordRepository;

    public EventRecordServiceImpl(EventRecordRepository eventRecordRepository) {
        this.eventRecordRepository = eventRecordRepository;
    }

    @Override
    public EventRecord createEvent(EventRecord event) {
        return eventRecordRepository.save(event);
    }

    @Override
    public Optional<EventRecord> getEventById(Long id) {
        return eventRecordRepository.findById(id);
    }

    @Override
    public List<EventRecord> getAllEvents() {
        return eventRecordRepository.findAll();
    }

    @Override
    public EventRecord updateEvent(Long id, EventRecord updatedEvent) {
        return eventRecordRepository.findById(id)
                .map(event -> {
                    event.setEventName(updatedEvent.getEventName());
                    event.setEventCode(updatedEvent.getEventCode());
                    event.setVenue(updatedEvent.getVenue());
                    event.setActive(updatedEvent.isActive());
                    event.setBasePrice(updatedEvent.getBasePrice());
                    return eventRecordRepository.save(event);
                })
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }

    @Override
    public void deleteEvent(Long id) {
        eventRecordRepository.deleteById(id);
    }
}
