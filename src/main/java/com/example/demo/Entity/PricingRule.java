package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pricing_rules")
public class PricingRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventCode;
    private Double demandMultiplier;
    private Double timeMultiplier;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEventCode() { return eventCode; }
    public void setEventCode(String eventCode) { this.eventCode = eventCode; }

    public Double getDemandMultiplier() { return demandMultiplier; }
    public void setDemandMultiplier(Double demandMultiplier) {
        this.demandMultiplier = demandMultiplier;
    }

    public Double getTimeMultiplier() { return timeMultiplier; }
    public void setTimeMultiplier(Double timeMultiplier) {
        this.timeMultiplier = timeMultiplier;
    }
}
