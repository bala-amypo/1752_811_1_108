package com.example.demo.repository;

import com.example.demo.model.SeatInventoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatInventoryRecordRepository extends JpaRepository<SeatInventoryRecord, Long> {

    // Repository method used in the service
    SeatInventoryRecord findByEventId(Long eventId);
}
