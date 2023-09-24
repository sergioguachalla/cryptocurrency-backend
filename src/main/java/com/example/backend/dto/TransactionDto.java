package com.example.backend.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionDto {
    private Long id;
    private String userId;
    private Long cryptocurrencyId;
    private Date date;
    private String type;
    private BigDecimal quantity;
    private BigDecimal price;

    public TransactionDto() {
    }

    public TransactionDto(Long id, String userId, Long cryptocurrencyId, Date date, String type, BigDecimal quantity, BigDecimal price) {
        this.id = id;
        this.userId = userId;
        this.cryptocurrencyId = cryptocurrencyId;
        this.date = date;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeycloakUserId() {
        return userId;
    }

    public void setKeycloakUserId(String keycloakUserId) {
        this.userId = keycloakUserId;
    }

    public Long getCryptocurrencyId() {
        return cryptocurrencyId;
    }

    public void setCryptocurrencyId(Long cryptocurrencyId) {
        this.cryptocurrencyId = cryptocurrencyId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
