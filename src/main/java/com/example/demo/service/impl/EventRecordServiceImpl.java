package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventRecordServiceImpl {

    private final EventRecordRepository repository;

    public EventRecordServiceImpl(EventRecordRepository repository) {
        this.repository = repository;
    }

    public boolean existsByEventCode(String code) {
        return repository.existsByEventCode(code);
    }

    public Optional<EventRecord> findByEventCode(String code) {
        return repository.findByEventCode(code);
    }
}
