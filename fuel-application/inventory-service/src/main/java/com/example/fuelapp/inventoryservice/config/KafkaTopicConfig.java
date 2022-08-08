package com.example.fuelapp.inventoryservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic fuelAllocatedTopic(){
        return TopicBuilder.name("fuel_allocated")
                .build();
    }
}
