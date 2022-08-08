package com.example.fuelapp.orderservice.service;

import com.example.fuelapp.orderservice.model.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public ResponseEntity<Order> saveOrder(Order order);
    public ResponseEntity<Optional<Order>> getOrder(int orderRefID);
    public ResponseEntity<List<Order>> getAllOrders();
    public ResponseEntity<Order> orderReceived(int orderRefID);

    public void updateStatusToAllocated(Order order);
    public void updateStatusToScheduled(Order order);
}
