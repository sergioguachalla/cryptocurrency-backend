package com.example.backend.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionDto {

    private Long id;
    private UserDto userId;
    private CryptocurrencyDto cryptocurrencyId;
    private String transactionType;

    private BigDecimal amount;

    private Date transactionDate;

public TransactionDto() {

    }

    public TransactionDto(Long id, UserDto userId, CryptocurrencyDto cryptocurrencyId, String transactionType, BigDecimal amount, Date transactionDate) {
        this.id = id;
        this.userId = userId;
        this.cryptocurrencyId = cryptocurrencyId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUserId() {
        return userId;
    }

    public void setUserId(UserDto userId) {
        this.userId = userId;
    }

    public CryptocurrencyDto getCryptocurrencyId() {
        return cryptocurrencyId;
    }

    public void setCryptocurrencyId(CryptocurrencyDto cryptocurrencyId) {
        this.cryptocurrencyId = cryptocurrencyId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTranscationType(String transcationType) {
        this.transactionType = transcationType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }


}
