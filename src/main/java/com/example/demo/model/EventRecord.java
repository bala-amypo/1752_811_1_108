package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "event_record")
public class EventRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private String eventName;
    private String location;

    // Getters and Setters
    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
