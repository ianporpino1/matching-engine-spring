package com.matchingengine.controller;

import com.matchingengine.model.Order;
import com.matchingengine.model.OrderResponse;
import com.matchingengine.service.MatchingEngine;
import com.matchingengine.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private MatchingEngine matchingEngine;
    
    @Autowired
    private OrderService orderService;
    
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody Order order) {
//        OrderResponse response = matchingEngine.matchOrder(order);
        orderService.createOrder(order);
        return ResponseEntity.ok(response);
    }
}
