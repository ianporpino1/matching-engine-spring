package com.matchingengine.repository;

import com.matchingengine.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserUsername(String username);
    List<Order> findOrdersByUserUsername(String username);

}
