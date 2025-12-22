package com.example.demo.controller;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@Tag(name = "Event CRUD APIs")
public class EventController {

    private final EventRecordRepository repository;

    public EventController(EventRecordRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public EventRecord create(@RequestBody EventRecord event) {
        return repository.save(event);
    }

    @GetMapping
    public List<EventRecord> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public EventRecord getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public EventRecord update(@PathVariable Long id, @RequestBody EventRecord event) {
        event.setId(id);
        return repository.save(event);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
