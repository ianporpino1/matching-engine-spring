package com.matchingengine.service;

import com.matchingengine.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderBookService {
    private final ConcurrentHashMap<String, OrderBook> orderBooks;
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private ExecutionService executionService;

    public OrderBookService() {
        this.orderBooks = new ConcurrentHashMap<>();
    }

    private OrderBook getOrderBook(String symbol) {
        return orderBooks.computeIfAbsent(symbol, k -> new OrderBook());
    }

    public OrderResponse processOrder(Order order) {
        OrderBook orderBook = getOrderBook(order.getSymbol());
        List<Execution> executions = orderBook.processOrder(order);
        
        if(executions.isEmpty()) {
            orderService.saveOrder(order);
            return new OrderResponse(
                    order.getId(),
                    order.getStatus(),
                    0,
                    order.getQuantity(),
                    order.getCreatedAt(),
                    order.getUser().getId()
            );
        }
        
        executionService.saveAllExecutions(executions);

        int executedQuantity = executions.stream()
                .filter(ex -> ex.getBuyOrder().equals(order) || ex.getSellOrder().equals(order))
                .mapToInt(Execution::getQuantity)
                .sum();

        int remainingQuantity = order.getQuantity();//ver qual o correto
        //int remainingQuantity = order.getQuantity() - executedQuantity;

        return new OrderResponse(
                order.getId(),
                order.getStatus(),
                executedQuantity,
                remainingQuantity,
                order.getCreatedAt(),
                order.getUser().getId()
        );
    }

}
