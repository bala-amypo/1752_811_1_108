package com.example.demo.repository;

import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.model.EventRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SeatInventoryRecordRepository extends JpaRepository<SeatInventoryRecord, Long> {
    Optional<SeatInventoryRecord> findByEvent(EventRecord event);
}
