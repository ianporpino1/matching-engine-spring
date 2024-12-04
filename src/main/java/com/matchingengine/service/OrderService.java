package com.matchingengine.service;

import com.matchingengine.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    
    public void createOrder(Order order) {
        
    }
    //orderRepo
    
    
}
