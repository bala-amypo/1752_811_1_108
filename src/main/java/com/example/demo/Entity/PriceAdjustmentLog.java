package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "price_adjustments")
public class PriceAdjustment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventCode;

    private String adjustmentType; 
    // Example: DEMAND, TIME, SEASONAL, MANUAL

    private Double adjustmentValue; 
    // Example: 1.2 (20% increase), 0.8 (20% decrease)

    private Double adjustedPrice;

    private LocalDateTime adjustedAt;

    @PrePersist
    public void onAdjust() {
        this.adjustedAt = LocalDateTime.now();
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

    public String getAdjustmentType() {
        return adjustmentType;
    }

    public void setAdjustmentType(String adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    public Double getAdjustmentValue() {
        return adjustmentValue;
    }

    public void setAdjustmentValue(Double adjustmentValue) {
        this.adjustmentValue = adjustmentValue;
    }

    public Double getAdjustedPrice() {
        return adjustedPrice;
    }

    public void setAdjustedPrice(Double adjustedPrice) {
        this.adjustedPrice = adjustedPrice;
    }

    public LocalDateTime getAdjustedAt() {
        return adjustedAt;
    }
}
