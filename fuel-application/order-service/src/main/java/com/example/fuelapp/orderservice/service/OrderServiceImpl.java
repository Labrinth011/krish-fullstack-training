package com.example.fuelapp.orderservice.service;

import com.example.fuelapp.orderservice.model.Order;
import com.example.fuelapp.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    private static final String RECEIVED_ORDER_TOPIC = "received_order";

    @Autowired
    OrderRepository orderRepository;

    @Override
    public ResponseEntity<Order> saveOrder(Order order) {
        Random random = new Random();
        int x  = random.nextInt(2500);
        try {
            order.setOrderRefId(x);
            orderRepository.save(order);
            kafkaTemplate.send(RECEIVED_ORDER_TOPIC, order);
        }catch(Exception e) {

        }
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @Override
    public ResponseEntity<Optional<Order>> getOrder(int orderRefID) {
        return ResponseEntity.status(HttpStatus.OK).body(orderRepository.findById(orderRefID));
    }

    @Override
    public ResponseEntity<Order> orderReceived(int orderRefID) {
        Optional<Order> byId = orderRepository.findById(orderRefID);
        if(byId.isPresent()) {
            Order order = byId.get();
            order.setStatus("Completed");
            orderRepository.save(order);
            return ResponseEntity.status(HttpStatus.OK).body(order);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(orderRepository.findAll());
    }

    @Override
    public void updateStatusToAllocated(Order order) {
        Optional<Order> orderData = orderRepository.findById(order.getOrderRefId());
        if(orderData.isPresent()){
            Order _order = orderData.get();
            _order.setStatus(order.getStatus());
            orderRepository.save(_order);
        }
    }

    @Override
    public void updateStatusToScheduled(Order order) {
        Optional<Order> orderData = orderRepository.findById(order.getOrderRefId());
        if(orderData.isPresent()){
            Order _order = orderData.get();
            _order.setStatus(order.getStatus());
            _order.setScheduledDate(order.getScheduledDate());
            orderRepository.save(_order);
        }
    }

    @Override
    public void updateStatusToDispatched(Order order) {
        Optional<Order> orderData = orderRepository.findById(order.getOrderRefId());
        if(orderData.isPresent()){
            Order _order = orderData.get();
            _order.setStatus("Dispatched");
            orderRepository.save(_order);
        }
    }
}
