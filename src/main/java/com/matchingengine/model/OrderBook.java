﻿package com.matchingengine.model;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class OrderBook {
    private final PriorityBlockingQueue<Order> buyOrders;
    private final PriorityBlockingQueue<Order> sellOrders;

    public OrderBook() {
        this.buyOrders = new PriorityBlockingQueue<>(1,(o1, o2) -> {
            int priceComparison = Double.compare(o2.getPrice(), o1.getPrice());
            if (priceComparison == 0) {
                return o1.getCreatedAt().compareTo(o2.getCreatedAt());
            }
            return priceComparison;
        });
        this.sellOrders = new PriorityBlockingQueue<>(1,(o1, o2) -> {
            int priceComparison = Double.compare(o1.getPrice(), o2.getPrice());
            if (priceComparison == 0) {
                return o1.getCreatedAt().compareTo(o2.getCreatedAt());
            }
            return priceComparison;
        });
    }

    public synchronized List<Execution> processOrder(Order order) {
        if (order.getType() == OrderType.BUY) {
            buyOrders.add(order);
        } else if (order.getType() == OrderType.SELL) {
            sellOrders.add(order);
        }
        return matchOrders();
    }

    private List<Execution> matchOrders() {
        List<Execution> executions = new ArrayList<>();

        while (!buyOrders.isEmpty() && !sellOrders.isEmpty()) {
            Order buyOrder = buyOrders.peek();
            Order sellOrder = sellOrders.peek();

            if (buyOrder.getPrice() >= sellOrder.getPrice()) {
                int quantity = Math.min(buyOrder.getQuantity(), sellOrder.getQuantity());
                double price = sellOrder.getPrice();

                executions.add(new Execution(buyOrder, sellOrder, quantity, price));

                buyOrder.setQuantity(buyOrder.getQuantity() - quantity);
                sellOrder.setQuantity(sellOrder.getQuantity() - quantity);

                if (buyOrder.getQuantity() == 0) {
                    buyOrder.setStatus(OrderStatus.TOTALLY_EXECUTED);
                    buyOrders.poll();
                } else {
                    buyOrder.setStatus(OrderStatus.PARTIALLY_EXECUTED);
                }
                if (sellOrder.getQuantity() == 0) {
                    sellOrder.setStatus(OrderStatus.TOTALLY_EXECUTED);
                    sellOrders.poll();
                } else {
                    sellOrder.setStatus(OrderStatus.PARTIALLY_EXECUTED);
                }
            } else {
                break;
            }
        }

        return executions;
    }


    public synchronized List<Order> getBuyOrders() {
        return new ArrayList<>(buyOrders);
    }

    public synchronized List<Order> getSellOrders() {
        return new ArrayList<>(sellOrders);
    }
}