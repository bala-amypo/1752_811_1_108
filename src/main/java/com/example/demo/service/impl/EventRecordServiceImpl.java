package com.example.demo.service.impl;

import com.example.demo.service.EventRecordService;
import org.springframework.stereotype.Service;

@Service
public class EventRecordServiceImpl implements EventRecordService {
    // implement methods if any
}

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
