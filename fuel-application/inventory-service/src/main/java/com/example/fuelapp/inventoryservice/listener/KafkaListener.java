package com.example.fuelapp.inventoryservice.listener;

import com.example.fuelapp.inventoryservice.model.Order;
import com.example.fuelapp.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaListener {

    @Autowired
    InventoryService inventoryService;

    @org.springframework.kafka.annotation.KafkaListener(
            topics = "received_order",
            groupId = "inventory-service-group",
            containerFactory = "orderReceivedListenerFactory"
    )
    void ReceivedListener(Order order) {
        inventoryService.reserveFromStorage(order);
    }

    @org.springframework.kafka.annotation.KafkaListener(
            topics = "dispatched-order",
            groupId = "inventory-service-group",
            containerFactory = "orderReceivedListenerFactory"
    )
    void DispatchedListener(Order order) {
        inventoryService.dispatchFromStorage(order);
    }
}
