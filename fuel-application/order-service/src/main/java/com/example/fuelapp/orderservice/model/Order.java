package com.example.fuelapp.orderservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class Order {

    @Id
    private int orderRefId;
    private int stationID;
    private String stationName;
    private String location;
    private int requiredCapacity;
    private String fuelType;
    private String status = "Pending";
    private String scheduledDate;

    public Order() {}

    public Order(int orderRefId, int stationID, String stationName, String location, int requiredCapacity, String fuelType, String status, String scheduledDate) {
        this.orderRefId = orderRefId;
        this.stationID = stationID;
        this.stationName = stationName;
        this.location = location;
        this.requiredCapacity = requiredCapacity;
        this.fuelType = fuelType;
        this.status = status;
        this.scheduledDate = scheduledDate;
    }

    public int getOrderRefId() {
        return orderRefId;
    }

    public void setOrderRefId(int orderRefId) {
        this.orderRefId = orderRefId;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRequiredCapacity() {
        return requiredCapacity;
    }

    public void setRequiredCapacity(int requiredCapacity) {
        this.requiredCapacity = requiredCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderRefId=" + orderRefId +
                ", stationID=" + stationID +
                ", stationName='" + stationName + '\'' +
                ", location='" + location + '\'' +
                ", requiredCapacity=" + requiredCapacity +
                ", fuelType='" + fuelType + '\'' +
                ", status='" + status + '\'' +
                ", scheduledDate='" + scheduledDate + '\'' +
                '}';
    }
}
