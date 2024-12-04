package com.matchingengine.model;

import java.time.Instant;

public class Execution {
    private Order buyOrder;
    private Order sellOrder;
    private int quantity;
    private double price;
    private Instant executedAt;

    public Execution(Order buyOrder, Order sellOrder, int quantity, double price) {
        this.buyOrder = buyOrder;
        this.sellOrder = sellOrder;
        this.quantity = quantity;
        this.price = price;
        this.executedAt = Instant.now();
    }

    public Order getBuyOrder() {
        return buyOrder;
    }

    public void setBuyOrder(Order buyOrder) {
        this.buyOrder = buyOrder;
    }

    public Order getSellOrder() {
        return sellOrder;
    }

    public void setSellOrder(Order sellOrder) {
        this.sellOrder = sellOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Instant getExecutedAt() {
        return executedAt;
    }

    public void setExecutedAt(Instant executedAt) {
        this.executedAt = executedAt;
    }
}