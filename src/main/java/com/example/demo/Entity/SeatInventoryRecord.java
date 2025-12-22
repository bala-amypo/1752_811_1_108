package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SeatInventoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer availableSeats;

    // getters & setters
}
