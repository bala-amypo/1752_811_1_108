package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.service.EventRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventRecordServiceImpl implements EventRecordService {

    @Autowired
    private EventRecordRepository eventRecordRepository;

    @Override
    public EventRecord createEvent(EventRecord event) {
        return eventRecordRepository.save(event);
    }

    @Override
    public EventRecord getEventById(Long id) {
        return eventRecordRepository.findById(id).orElse(null);
    }

    @Override
    public List<EventRecord> getAllEvents() {
        return eventRecordRepository.findAll();
    }

    @Override
    public EventRecord updateEventStatus(Long id, boolean active) {
        Optional<EventRecord> optional = eventRecordRepository.findById(id);
        if (optional.isPresent()) {
            EventRecord event = optional.get();
            event.setActive(active);
            return eventRecordRepository.save(event);
        }
        return null;
    }
}
