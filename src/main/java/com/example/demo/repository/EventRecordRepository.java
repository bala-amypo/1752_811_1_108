package com.example.demo.repository;

import com.example.demo.model.EventRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRecordRepository extends JpaRepository<EventRecord, Long> {
    
    // Find event by eventCode
    Optional<EventRecord> findByEventCode(String eventCode);

    // Check if eventCode exists
    boolean existsByEventCode(String eventCode);
}
