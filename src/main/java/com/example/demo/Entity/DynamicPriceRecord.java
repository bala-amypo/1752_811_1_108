package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DynamicPriceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventCode;
    private double price;

    public Long getId() { return id; }
    public String getEventCode() { return eventCode; }
    public void setEventCode(String eventCode) { this.eventCode = eventCode; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
