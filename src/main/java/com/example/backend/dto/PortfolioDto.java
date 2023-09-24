package com.example.backend.dto;

import java.math.BigDecimal;
import java.util.List;

public class PortfolioDto {

    private Integer userId;
    private List<CryptocurrencyDto> cryptocurrencyList;
    private BigDecimal totalAmount;
    private BigDecimal amountInUsd;

    public PortfolioDto() {
    }

    public PortfolioDto( Integer userId, List<CryptocurrencyDto> cryptocurrencyList, BigDecimal totalAmount, BigDecimal amountInUsd) {

        this.userId = userId;
        this.cryptocurrencyList = cryptocurrencyList;
        this.totalAmount = totalAmount;
        this.amountInUsd = amountInUsd;
    }


}
