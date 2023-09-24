package com.example.backend.entity;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "crypto_id", referencedColumnName = "id")
    private Cryptocurrency cryptocurrencyId;

    @Column(name = "type", nullable = false)
    private String transactionType;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "date", nullable = false)
    private Date transactionDate;


    public Transaction(Long id, User user, Cryptocurrency cryptocurrencyId, String transactionType, BigDecimal amount, BigDecimal price, Date transactionDate) {
        this.id = id;
        this.user = user;
        this.cryptocurrencyId = cryptocurrencyId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.price = price;
        this.transactionDate = transactionDate;
    }

    public Transaction() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cryptocurrency getCryptocurrencyId() {
        return cryptocurrencyId;
    }

    public void setCryptocurrencyId(Cryptocurrency cryptocurrencyId) {
        this.cryptocurrencyId = cryptocurrencyId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
