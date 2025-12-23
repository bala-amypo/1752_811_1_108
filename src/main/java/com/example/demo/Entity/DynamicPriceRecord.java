package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dynamic_price_records")
public class DynamicPriceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventCode;
    private Double basePrice;
    private Double finalPrice;
    private Double demandMultiplier;
    private Double timeMultiplier;

    private LocalDateTime calculatedAt;

    @PrePersist
    public void onCalculate() {
        this.calculatedAt = LocalDateTime.now();
    }

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

    public Double getBasePrice() { 
        return basePrice; 
    }

    public void setBasePrice(Double basePrice) { 
        this.basePrice = basePrice; 
    }

    public Double getFinalPrice() { 
        return finalPrice; 
    }

    public void setFinalPrice(Double finalPrice) { 
        this.finalPrice = finalPrice; 
    }

    public Double getDemandMultiplier() { 
        return demandMultiplier; 
    }

    public void setDemandMultiplier(Double demandMultiplier) {
        this.demandMultiplier = demandMultiplier;
    }

    public Double getTimeMultiplier() { 
        return timeMultiplier; 
    }

    public void setTimeMultiplier(Double timeMultiplier) {
        this.timeMultiplier = timeMultiplier;
    }

    public LocalDateTime getCalculatedAt() { 
        return calculatedAt; 
    }
}
