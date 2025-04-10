package com.example.notification_system.kafka;
import com.example.notification_system.model.Notification;
import com.example.notification_system.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationConsumer {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private NotificationRepository notificationRepository;

    @KafkaListener(topics = "notification-topic", groupId = "notification-group")
    public void consume(String message) {

        String[] parts = message.split("\\|");
        if (parts.length < 2) return;

        String userId = parts[0];
        String content = parts[1];

        // Save to DB
        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setMessage(content);
        notification.setTimestamp(LocalDateTime.now());

        notificationRepository.save(notification);

        // Push to WebSocket
        messagingTemplate.convertAndSend("/topic/notifications/" + userId, content);
    }
}
