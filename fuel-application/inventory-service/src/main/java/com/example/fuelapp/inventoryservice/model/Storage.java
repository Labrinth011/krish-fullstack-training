package com.example.fuelapp.inventoryservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "storage")
public class Storage {
    @Id
    private String fuelTypeID;
    private String fuelType;
    private int availableQuantity;
    private int usableQuantity;
    private int reservedQuantity;

    public Storage(){}

    public Storage(String fuelTypeID, String fuelType, int availableQuantity, int usableQuantity, int reservedQuantity) {
        this.fuelTypeID = fuelTypeID;
        this.fuelType = fuelType;
        this.availableQuantity = availableQuantity;
        this.usableQuantity = usableQuantity;
        this.reservedQuantity = reservedQuantity;
    }

    public String getFuelTypeID() {
        return fuelTypeID;
    }

    public void setFuelTypeID(String fuelTypeID) {
        this.fuelTypeID = fuelTypeID;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getUsableQuantity() {
        return usableQuantity;
    }

    public void setUsableQuantity(int usableQuantity) {
        this.usableQuantity = usableQuantity;
    }

    public int getReservedQuantity() {
        return reservedQuantity;
    }

    public void setReservedQuantity(int reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "fuelTypeID='" + fuelTypeID + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", availableQuantity=" + availableQuantity +
                ", usableQuantity=" + usableQuantity +
                ", reservedQuantity=" + reservedQuantity +
                '}';
    }
}

