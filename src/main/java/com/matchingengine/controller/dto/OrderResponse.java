package com.matchingengine.controller.dto;

import com.matchingengine.model.Order;
import com.matchingengine.model.OrderStatus;
import com.matchingengine.service.OrderService;

import java.time.Instant;

public record OrderResponse(Long orderId,
        OrderStatus orderStatus,
        int executedQuantity,
        int remainingQuantity,
        Instant orderDate,
        Long userId) {
    public OrderResponse(Order order) {
        this(order.getId(), 
                order.getStatus(), 
                order.getTotalQuantity() - order.getRemainingQuantity(), 
                order.getRemainingQuantity(), 
                order.getCreatedAt(), 
                order.getUser().getId());
    }
}