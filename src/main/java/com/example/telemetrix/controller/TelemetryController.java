package com.example.telemetrix.controller;

import com.example.telemetrix.model.TelemetryEvent;
import com.example.telemetrix.service.TelemetryConsumer;
import com.example.telemetrix.service.TelemetryProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/telemetry")
public class TelemetryController {
    private final TelemetryProducer producer;
    private final TelemetryConsumer consumer;

    public TelemetryController(TelemetryProducer producer, TelemetryConsumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody TelemetryEvent event) {
        producer.send(event);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/recent")
    public List<TelemetryEvent> recent(@RequestParam(defaultValue = "20") int limit) {
        return consumer.getRecent(limit);
    }
}