package com.example.fuelapp.scheduleservice.service;


import com.example.fuelapp.scheduleservice.model.Order;

public interface ScheduleService {
    public void updateStatusToScheduled(Order order);

}
