package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "seat_inventory")
public class SeatInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;

    private String seatNumber;

    private boolean booked;

    // Constructors
    public SeatInventory() {}

    public SeatInventory(Long eventId, String seatNumber, boolean booked) {
        this.eventId = eventId;
        this.seatNumber = seatNumber;
        this.booked = booked;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
