package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CRYPTOCURRENCY")
public class Cryptocurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "status")
    private boolean status;

    @Column(name = "current_price")
    private double currentPrice;

    public Cryptocurrency(Long id, String name, String symbol, boolean status, double currentPrice) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.status = status;
        this.currentPrice = currentPrice;
    }

    public Cryptocurrency() {

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
