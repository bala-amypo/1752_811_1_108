package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SeatInventoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "event_id")
    private EventRecord event;

    private int totalSeats;
    private int remainingSeats;

    // Constructors
    public SeatInventoryRecord() {}
    public SeatInventoryRecord(EventRecord event, int totalSeats, int remainingSeats) {
        this.event = event;
        this.totalSeats = totalSeats;
        this.remainingSeats = remainingSeats;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public EventRecord getEvent() { return event; }
    public void setEvent(EventRecord event) { this.event = event; }
    public int getTotalSeats() { return totalSeats; }
    public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }
    public int getRemainingSeats() { return remainingSeats; }
    public void setRemainingSeats(int remainingSeats) { this.remainingSeats = remainingSeats; }
}
