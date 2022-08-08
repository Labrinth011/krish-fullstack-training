package com.example.fuelapp.inventoryservice.repository;

import com.example.fuelapp.inventoryservice.model.Storage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends MongoRepository <Storage, String> {

}
