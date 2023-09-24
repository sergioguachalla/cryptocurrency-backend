package com.example.backend.dto;

import java.math.BigDecimal;
import java.util.List;

public class PortfolioDto {

    private String keycloakUserId;
    private String cryptocurrencyName;

    private String cryptocurrencySymbol;
    private BigDecimal totalAmount;
    private BigDecimal amountInUsd;

    public PortfolioDto() {
    }

    public PortfolioDto(String keycloakUserId, String cryptocurrencyName, String cryptocurrencySymbol, BigDecimal totalAmount, BigDecimal amountInUsd) {
        this.keycloakUserId = keycloakUserId;
        this.cryptocurrencyName = cryptocurrencyName;
        this.cryptocurrencySymbol = cryptocurrencySymbol;
        this.totalAmount = totalAmount;
        this.amountInUsd = amountInUsd;
    }

    public String getKeycloakUserId() {
        return keycloakUserId;
    }

    public void setKeycloakUserId(String keycloakUserId) {
        this.keycloakUserId = keycloakUserId;
    }

    public String getCryptocurrencyName() {
        return cryptocurrencyName;
    }

    public void setCryptocurrencyName(String cryptocurrencyName) {
        this.cryptocurrencyName = cryptocurrencyName;
    }

    public String getCryptocurrencySymbol() {
        return cryptocurrencySymbol;
    }

    public void setCryptocurrencySymbol(String cryptocurrencySymbol) {
        this.cryptocurrencySymbol = cryptocurrencySymbol;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getAmountInUsd() {
        return amountInUsd;
    }

    public void setAmountInUsd(BigDecimal amountInUsd) {
        this.amountInUsd = amountInUsd;
    }
}
