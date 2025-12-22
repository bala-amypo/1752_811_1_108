package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "dynamic_price_records")
public class DynamicPriceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
