package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "event_records")
public class EventRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String eventCode;

    @Column(nullable = false)
    private String eventName;

    private String venue;

    private boolean active;

    private int basePrice;

    // Default constructor
    public EventRecord() {
    }

    // Constructor with all fields except id
    public EventRecord(String eventCode, String eventName, String venue, boolean active, int basePrice) {
        this.eventCode = eventCode;
        this.eventName = eventName;
        this.venue = venue;
        this.active = active;
        this.basePrice = basePrice;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "EventRecord{" +
                "id=" + id +
                ", eventCode='" + eventCode + '\'' +
                ", eventName='" + eventName + '\'' +
                ", venue='" + venue + '\'' +
                ", active=" + active +
                ", basePrice=" + basePrice +
                '}';
    }
}
