package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SeatInventoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalSeats;
    private int remainingSeats;

    @ManyToOne
    @JoinColumn(name = "event_id") // <-- DB column for foreign key
    private EventRecord event;       // <-- reference to EventRecord

    // Constructors
    public SeatInventoryRecord() {}

    public SeatInventoryRecord(int totalSeats, int remainingSeats, EventRecord event) {
        this.totalSeats = totalSeats;
        this.remainingSeats = remainingSeats;
        this.event = event;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public EventRecord getEvent() {
        return event;
    }

    public void setEvent(EventRecord event) {
        this.event = event;
    }
}
