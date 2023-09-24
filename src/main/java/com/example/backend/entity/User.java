package com.example.backend.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "keycloak_id")
    private String keyCloakId;

    @Column(name = "name")
    private String name;


    public User() {

    }
    public User(Long id, String username, String keyCloakId, String name) {
        this.id = id;
        this.username = username;
        this.name  = name;
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

    public String getKeyCloakId() {
        return keyCloakId;
    }

    public void setKeyCloakId(String keyCloakId) {
        this.keyCloakId = keyCloakId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
