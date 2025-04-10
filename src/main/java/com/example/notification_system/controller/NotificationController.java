package com.example.notification_system.controller;

import com.example.notification_system.kafka.NotificationProducer;
import com.example.notification_system.model.Notification;
import com.example.notification_system.model.NotificationEvent;
import com.example.notification_system.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationProducer producer;

    @Autowired
    private NotificationRepository notificationRepository;

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
    @GetMapping("/notifications/{userId}")
    public ResponseEntity<List<Notification>> getUserNotifications(@PathVariable String userId) {
        List<Notification> notifications = notificationRepository.findByUserId(userId);
        return ResponseEntity.ok(notifications);
    }



}
