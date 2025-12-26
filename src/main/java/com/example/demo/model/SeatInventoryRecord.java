package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "seat_inventory_record")
public class SeatInventoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "event_id", referencedColumnName = "eventId")
    private EventRecord event;

    private int totalSeats;
    private int remainingSeats;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public EventRecord getEvent() { return event; }
    public void setEvent(EventRecord event) { this.event = event; }

    public int getTotalSeats() { return totalSeats; }
    public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }

    public int getRemainingSeats() { return remainingSeats; }
    public void setRemainingSeats(int remainingSeats) { this.remainingSeats = remainingSeats; }
}
