package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.EventRecord;

public interface EventRecordService {

    EventRecord create(EventRecord event);

    EventRecord getById(Long id);

    List<EventRecord> getAll();

    EventRecord update(Long id, EventRecord event);

    void delete(Long id);
}
