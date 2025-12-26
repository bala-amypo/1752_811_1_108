package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "seat_inventory")
public class SeatInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private EventRecord event;

    @Column(nullable = false)
    private int totalSeats;

    @Column(nullable = false)
    private int remainingSeats;

    // Constructors
    public SeatInventory() {}

    public SeatInventory(EventRecord event, int totalSeats, int remainingSeats) {
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
