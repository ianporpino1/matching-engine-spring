package com.matchingengine.model;

import jakarta.persistence.*;

import java.time.Instant;
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String symbol;
    private OrderType type;
    private OrderStatus status;
    private double price;
    private int quantity;
    private Instant createdAt;
    @ManyToOne
    private User user;

    public Order(String symbol, OrderType type, int quantity, double price) {
        this.symbol = symbol;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.createdAt = Instant.now();
        this.status = OrderStatus.ACCEPTED;
    }

    public Order() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public OrderType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
