package com.matchingengine.service;

import com.matchingengine.controller.dto.OrderResponse;
import com.matchingengine.model.Order;
import com.matchingengine.model.User;
import com.matchingengine.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }



    public List<OrderResponse> getUserAuthenticatedOrders(UserDetails userDetails) {
        String username = userDetails.getUsername();
        return orderRepository.findOrdersByUserUsername(username).stream()
                .map(OrderResponse::new)
                .toList();
    }

    public void saveAllOrders(Set<Order> ordersToSave) {
        orderRepository.saveAll(ordersToSave);
    }
}
