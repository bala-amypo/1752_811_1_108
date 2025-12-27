package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class PricingRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private Double multiplier;
    private boolean active;

    // getters & setters
    public Long getId() { return id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public Double getMultiplier() { return multiplier; }
    public void setMultiplier(Double multiplier) { this.multiplier = multiplier; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
