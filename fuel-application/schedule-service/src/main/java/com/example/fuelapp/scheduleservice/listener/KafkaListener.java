package com.example.fuelapp.scheduleservice.listener;

import com.example.fuelapp.scheduleservice.model.Order;
import com.example.fuelapp.scheduleservice.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class KafkaListener {

    @Autowired
    ScheduleService scheduleService;

    @org.springframework.kafka.annotation.KafkaListener(
            topics = "fuel_allocated",
            groupId = "schedule-service-group",
            containerFactory = "fuelAllocatedListenerFactory"
    )
    void listener(Order order) throws InterruptedException {
        TimeUnit.MINUTES.sleep(1);
        scheduleService.updateStatusToScheduled(order);
    }
}