package com.example.demo.repository;

import com.example.demo.model.SeatInventory;
import com.example.demo.model.EventRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SeatInventoryRepository extends JpaRepository<SeatInventory, Long> {
    Optional<SeatInventory> findByEvent(EventRecord event);
}
