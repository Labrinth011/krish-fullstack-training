package com.example.fuelapp.scheduleservice.service;

import com.example.fuelapp.scheduleservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    private static final String SCHEDULED_ORDER_TOPIC = "scheduled-order";

    @Override
    public void updateStatusToScheduled(Order order) {
        order.setStatus("Scheduled");
        order.setScheduledDate(getScheduledDate());
        kafkaTemplate.send(SCHEDULED_ORDER_TOPIC, order);
    }

    public String getScheduledDate(){
        LocalDate today = LocalDate.now();
        Random random = new Random();
        int x  = random.nextInt(8);
        return today.plusDays(x).toString();
    }

}
