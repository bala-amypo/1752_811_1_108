package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "seat_inventory")
public class SeatInventoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer availableSeats;

    public Long getId() {
        return id;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }
}
