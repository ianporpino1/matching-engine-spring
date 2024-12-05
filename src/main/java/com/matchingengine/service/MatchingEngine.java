package com.matchingengine.service;

import com.matchingengine.model.Order;
import com.matchingengine.model.OrderRequest;
import com.matchingengine.model.OrderResponse;
import com.matchingengine.model.User;
import org.springframework.stereotype.Service;

@Service
public class MatchingEngine {
    public OrderBookService orderBookService;
    //private final NotificationService notificationService;

    public MatchingEngine(OrderBookService orderBookService) {
        this.orderBookService = orderBookService;
    }

    public OrderResponse matchOrder(OrderRequest orderRequest) {
        Order order = new Order(orderRequest.symbol(),orderRequest.orderType(),orderRequest.quantity(),orderRequest.price());
        User user = new User();
        user.setId(1L);
        order.setUser(user);
        OrderResponse response = orderBookService.processOrder(order);

       // notificationService.notifyOrderStatus(order.getUserId(), response);
        return response;
    }

}
