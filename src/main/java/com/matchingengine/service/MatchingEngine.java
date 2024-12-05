package com.matchingengine.service;

import com.matchingengine.model.Order;
import com.matchingengine.model.OrderRequest;
import com.matchingengine.model.OrderResponse;
import com.matchingengine.model.User;
import com.matchingengine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchingEngine {
    public OrderBookService orderBookService;
    //private final NotificationService notificationService;
    
    @Autowired
    private UserRepository userRepository;

    public MatchingEngine(OrderBookService orderBookService) {
        this.orderBookService = orderBookService;
    }

    public OrderResponse matchOrder(OrderRequest orderRequest) {
        Order order = new Order(orderRequest.symbol(),orderRequest.orderType(),orderRequest.quantity(),orderRequest.price());
        
        OrderResponse response = orderBookService.processOrder(order);

       // notificationService.notifyOrderStatus(order.getUserId(), response);
        return response;
    }

}
