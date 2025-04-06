package com.example.notification_system.controller;

import com.example.notification_system.kafka.NotificationProducer;
import com.example.notification_system.model.NotificationEvent;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationProducer producer;

    public NotificationController(NotificationProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public String sendNotification(@RequestParam String userId, @RequestParam String message) {
        NotificationEvent event = new NotificationEvent(
                userId,
                message,
                Instant.now().toString()
        );

        producer.sendNotification(event);
        return "✅ Notification sent to Kafka for user: " + userId;
    }
}
