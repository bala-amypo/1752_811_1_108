package com.example.demo.repository;

import com.example.demo.model.SeatInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatInventoryRepository extends JpaRepository<SeatInventory, Long> {
    List<SeatInventory> findByEventId(Long eventId);
}
