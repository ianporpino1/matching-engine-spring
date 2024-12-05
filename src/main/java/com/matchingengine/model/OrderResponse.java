package com.matchingengine.model;

import java.time.Instant;

public record OrderResponse(Long orderId,
        OrderStatus orderStatus,
        int executedQuantity,
        int remainingQuantity,
        Instant orderDate,
        Long userId) {}
