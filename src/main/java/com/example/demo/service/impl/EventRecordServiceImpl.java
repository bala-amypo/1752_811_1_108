package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.service.EventRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventRecordServiceImpl implements EventRecordService {

    private final EventRecordRepository repo;

    public EventRecordServiceImpl(EventRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public EventRecord create(EventRecord event) {
        return repo.save(event);
    }

    @Override
    public EventRecord getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public List<EventRecord> getAll() {
        return repo.findAll();
    }

    @Override
    public EventRecord update(Long id, EventRecord event) {
        EventRecord existing = getById(id);
        existing.setEventCode(event.getEventCode());
        existing.setEventName(event.getEventName());
        existing.setVenue(event.getVenue());
        existing.setBasePrice(event.getBasePrice());
        existing.setActive(event.isActive());
        return repo.save(existing);
    }

    @Override
    public EventRecord updateEventStatus(Long id, boolean active) {
        EventRecord event = getById(id);
        event.setActive(active);
        return repo.save(event);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
