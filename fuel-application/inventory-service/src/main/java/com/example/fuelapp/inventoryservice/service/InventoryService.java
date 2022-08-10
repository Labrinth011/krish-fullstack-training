package com.example.fuelapp.inventoryservice.service;

import com.example.fuelapp.inventoryservice.model.Order;

public interface InventoryService {
    public void reserveFromStorage(Order order);
    public void dispatchFromStorage(Order order);

}
