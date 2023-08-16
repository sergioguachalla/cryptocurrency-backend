package com.example.backend.dto;

import java.math.BigDecimal;

public class UserDto {

    private Long id;
    private String username;
    private String email;
    private BigDecimal balance;
    private boolean status;

    public UserDto() {

    }
    public UserDto(Long id, String username, String email, BigDecimal balance, boolean status) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.balance = balance;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
