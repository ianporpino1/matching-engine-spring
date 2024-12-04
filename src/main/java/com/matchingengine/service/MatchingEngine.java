package com.matchingengine.service;

import com.matchingengine.model.Order;
import com.matchingengine.model.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public class MatchingEngine {
    public OrderBookService orderBookService;
    //private final NotificationService notificationService;

    public MatchingEngine(OrderBookService orderBookService) {
        this.orderBookService = orderBookService;
    }

    public OrderResponse matchOrder(Order order) {
        OrderResponse response = orderBookService.processOrder(order);

       // notificationService.notifyOrderStatus(order.getUserId(), response);
        return response;
    }

}
