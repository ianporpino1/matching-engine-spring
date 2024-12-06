package com.matchingengine.controller;

import com.matchingengine.controller.dto.OrderRequest;
import com.matchingengine.controller.dto.OrderResponse;
import com.matchingengine.model.User;
import com.matchingengine.service.MatchingEngine;
import com.matchingengine.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private MatchingEngine matchingEngine;
    
    @Autowired
    private OrderService orderService;
    
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest, @AuthenticationPrincipal UserDetails user) {

        OrderResponse response  = matchingEngine.matchOrder(orderRequest, user);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getUserOrders(@AuthenticationPrincipal UserDetails user) {
        List<OrderResponse> orders = orderService.getUserAuthenticatedOrders(user);
        return ResponseEntity.ok(orders);
    }
}
