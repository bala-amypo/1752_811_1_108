package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.service.EventRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventRecordServiceImpl implements EventRecordService {

    private final EventRecordRepository repository;

    public EventRecordServiceImpl(EventRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public EventRecord create(EventRecord event) {
        return repository.save(event);
    }

    @Override
    public EventRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public List<EventRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public EventRecord update(Long id, EventRecord event) {
        EventRecord existing = getById(id);
        existing.setEventCode(event.getEventCode());
        existing.setEventName(event.getEventName());
        existing.setVenue(event.getVenue());
        existing.setActive(event.isActive());
        existing.setBasePrice(event.getBasePrice());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
