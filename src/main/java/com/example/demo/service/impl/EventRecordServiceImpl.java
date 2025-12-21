package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.service.EventRecordService;

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
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<EventRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public EventRecord update(Long id, EventRecord event) {
        event.setId(id);
        return repository.save(event);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
