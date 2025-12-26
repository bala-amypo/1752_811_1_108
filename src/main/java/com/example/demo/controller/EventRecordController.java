package com.example.demo.controller;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@Tag(name = "Event API")
public class EventRecordController {

    private final EventRecordRepository repository;

    public EventRecordController(EventRecordRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<EventRecord> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public EventRecord create(@RequestBody EventRecord event) {
        return repository.save(event);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
