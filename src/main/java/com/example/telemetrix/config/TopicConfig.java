package com.example.telemetrix.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {
    @Bean
    public NewTopic telemetryTopic() {
        return new NewTopic("telemetry", 1, (short) 1);
    }
}