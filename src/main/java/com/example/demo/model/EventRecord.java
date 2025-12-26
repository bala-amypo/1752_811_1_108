package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class EventRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private String eventCode;
    private String eventName;
    private String venue;
    private boolean active;
    private double basePrice;

    // Constructors
    public EventRecord() {}
    public EventRecord(String eventCode, String eventName, String venue, boolean active, double basePrice) {
        this.eventCode = eventCode;
        this.eventName = eventName;
        this.venue = venue;
        this.active = active;
        this.basePrice = basePrice;
    }

    // Getters & Setters
    public Long getEventId() { return eventId; }

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
