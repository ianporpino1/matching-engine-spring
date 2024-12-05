package com.matchingengine.service;

import com.matchingengine.model.Order;
import com.matchingengine.model.OrderRequest;
import com.matchingengine.model.OrderResponse;
import com.matchingengine.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
    
    
}
