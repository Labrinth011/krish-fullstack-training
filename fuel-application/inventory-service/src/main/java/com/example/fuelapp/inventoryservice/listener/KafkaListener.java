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
    void listener(Order order){
        inventoryService.reserveFromStorage(order);
    }
}
