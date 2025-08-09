package com.example.telemetrix.service;

import com.example.telemetrix.model.TelemetryEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TelemetryProducer {
    private final KafkaTemplate<String, TelemetryEvent> kafkaTemplate;
    private static final String TOPIC = "telemetry";

    public TelemetryProducer(KafkaTemplate<String, TelemetryEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(TelemetryEvent event) {
        kafkaTemplate.send(TOPIC, event.getCarId(), event);
    }
}