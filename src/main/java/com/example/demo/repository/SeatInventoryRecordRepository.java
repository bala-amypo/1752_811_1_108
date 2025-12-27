package com.example.demo.repository;

import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.model.EventRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatInventoryRecordRepository
        extends JpaRepository<SeatInventoryRecord, Long> {

    List<SeatInventoryRecord> findByEvent(EventRecord event);
}
