package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.service.EventRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventRecordServiceImpl implements EventRecordService {

    private final EventRecordRepository repo;

    public EventRecordServiceImpl(EventRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public EventRecord createEvent(EventRecord event) {
        if (repo.existsByEventCode(event.getEventCode()))
            throw new BadRequestException("Event code already exists");
        if (event.getBasePrice() <= 0)
            throw new BadRequestException("Base price must be > 0");
        return repo.save(event);
    }

    @Override
    public EventRecord getEventById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public Optional<EventRecord> getEventByCode(String code) {
        return repo.findByEventCode(code);
    }

    @Override
    public List<EventRecord> getAllEvents() {
        return repo.findAll();
    }

    @Override
    public EventRecord updateEventStatus(Long id, boolean active) {
        EventRecord e = getEventById(id);
        e.setActive(active);
        return repo.save(e);
    }
}
