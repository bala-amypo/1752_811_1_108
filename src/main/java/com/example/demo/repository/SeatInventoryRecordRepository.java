package com.example.demo.repository;

import com.example.demo.model.SeatInventoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatInventoryRecordRepository extends JpaRepository<SeatInventoryRecord, Long> {
    // You can add custom queries here if needed
}
