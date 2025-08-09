package com.example.telemetrix.service;

import com.example.telemetrix.model.TelemetryEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelemetryConsumer {
    private final Deque<TelemetryEvent> recent = new ConcurrentLinkedDeque<>();

    @KafkaListener(topics = "telemetry", groupId = "telemetrix-consumer")
    public void listen(TelemetryEvent event) {
        recent.addFirst(event);
        if (recent.size() > 100) recent.removeLast();
    }

    public List<TelemetryEvent> getRecent(int n) {
        return recent.stream().limit(n).collect(Collectors.toList());
    }
}