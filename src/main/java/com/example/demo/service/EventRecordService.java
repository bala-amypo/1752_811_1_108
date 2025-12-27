package com.example.demo.service;

import com.example.demo.model.EventRecord;
import java.util.List;

public interface EventRecordService {

    EventRecord create(EventRecord event);

    EventRecord getById(Long id);

    List<EventRecord> getAll();

    EventRecord update(Long id, EventRecord event);

    EventRecord updateEventStatus(Long id, boolean active);

    void delete(Long id);
}
