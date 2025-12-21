package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EventRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventName;

    private double basePrice;

    // getters & setters
}
