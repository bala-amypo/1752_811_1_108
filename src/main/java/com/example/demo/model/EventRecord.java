package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "event_records")
public class EventRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @Column(nullable = false, unique = true)
    private String eventCode;

    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false)
    private String venue;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private double basePrice;

    @Column
    private LocalDate eventDate;

    public EventRecord() {}

    public EventRecord(String eventCode, String eventName, String venue, boolean active, double basePrice, LocalDate eventDate) {
        this.eventCode = eventCode;
        this.eventName = eventName;
        this.venue = venue;
        this.active = active;
        this.basePrice = basePrice;
        this.eventDate = eventDate;
    }

    // Getters and Setters
    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
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

    // Boolean getter uses isActive() for proper Java conventions
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    // Optional helper methods for JPA lifecycle
    @PrePersist
    public void prePersist() {
        if (eventDate == null) {
            eventDate = LocalDate.now();
        }
    }
}
