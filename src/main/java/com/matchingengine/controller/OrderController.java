package com.matchingengine.controller;

import com.matchingengine.model.OrderRequest;
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
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {

        OrderResponse response  = matchingEngine.matchOrder(orderRequest);
        return ResponseEntity.ok(response);
    }
}
