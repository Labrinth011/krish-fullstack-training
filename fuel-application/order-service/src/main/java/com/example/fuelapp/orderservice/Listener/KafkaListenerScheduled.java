package com.example.fuelapp.orderservice.Listener;

import com.example.fuelapp.orderservice.model.Order;
import com.example.fuelapp.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerScheduled {

    @Autowired
    private OrderService orderService;

    @org.springframework.kafka.annotation.KafkaListener(
            topics = "scheduled-order",
            groupId = "order-service-group",
            containerFactory = "fuelAllocatedListenerFactory"
    )
    void listener(Order order){
        orderService.updateStatusToScheduled(order);
    }
}