package com.example.fuelapp.inventoryservice.service;

import com.example.fuelapp.inventoryservice.model.Order;
import com.example.fuelapp.inventoryservice.model.Storage;
import com.example.fuelapp.inventoryservice.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService{

    private static final String FUEL_ALLOCATED_TOPIC = "fuel_allocated";
    private static int counter = 0;

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @Autowired
    StorageRepository storageRepository;

    @Override
    public void reserveFromStorage(Order order) {
        Optional<Storage> storageData = storageRepository.findById(order.getFuelType());
        if(storageData.isPresent()){
            Storage _storage = storageData.get();

            int newUpdatedQuantity = (_storage.getUsableQuantity()) - (order.getRequiredCapacity());
            int newReservedQuantity = (_storage.getReservedQuantity()) + (order.getRequiredCapacity());

            _storage.setUsableQuantity(newUpdatedQuantity);
            _storage.setReservedQuantity(newReservedQuantity);
            storageRepository.save(_storage);

            order.setStatus("Allocated");
            kafkaTemplate.send(FUEL_ALLOCATED_TOPIC, order);
        }
    }

    @Override
    public void dispatchFromStorage(Order order) {
        Optional<Storage> storageData = storageRepository.findById(order.getFuelType());
        if(storageData.isPresent()){
            Storage _storage = storageData.get();

            int newAvailableQuantity = ((_storage.getAvailableQuantity()) - (order.getRequiredCapacity()));
            int newReservedQuantity = ((_storage.getReservedQuantity()) - (order.getRequiredCapacity()));

            _storage.setAvailableQuantity(newAvailableQuantity);
            _storage.setReservedQuantity(newReservedQuantity);
            storageRepository.save(_storage);
        }
    }
}
