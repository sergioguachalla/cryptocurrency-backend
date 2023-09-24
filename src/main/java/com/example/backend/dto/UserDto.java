package com.example.backend.dto;

import java.math.BigDecimal;

public class UserDto {

    private Long id;
    private String username;
    private String name;
    private String keyCloakId;
    private String email;
    private BigDecimal balance;

    public UserDto() {

    }
    public UserDto(Long id, String username, String email, BigDecimal balance, String name, String keyCloakId) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.balance = balance;
        this.name = name;
        this.keyCloakId = keyCloakId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyCloakId() {
        return keyCloakId;
    }

    public void setKeyCloakId(String keyCloakId) {
        this.keyCloakId = keyCloakId;
    }
}
