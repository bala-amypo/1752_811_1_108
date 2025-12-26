package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "event_records")
public class EventRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventCode;
    private String eventName;
    private String venue;
    private boolean active;
    private double basePrice;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEventCode() { return eventCode; }
    public void setEventCode(String eventCode) { this.eventCode = eventCode; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public double getBasePrice() { return basePrice; }
    public void setBasePrice(double basePrice) { this.basePrice = basePrice; }
}
