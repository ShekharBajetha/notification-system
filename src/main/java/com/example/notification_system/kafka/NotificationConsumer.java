package com.example.notification_system.kafka;

import com.example.notification_system.model.NotificationEvent;
import com.example.notification_system.websocket.NotificationWebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static org.apache.kafka.common.requests.DeleteAclsResponse.log;

@Service
public class NotificationConsumer {

    @Autowired
    private NotificationWebSocketService webSocketService;

    @KafkaListener(topics = "notification-topic", groupId = "notification-group")
    public void consume(NotificationEvent event) {
        System.out.println("✅ Notification received for user ID: " + event.getUserId() +
                " | Message: " + event.getMessage());
        // Future enhancement: trigger WebSocket/push/DB save/etc.
    }

    @KafkaListener(topics = "notification-topic", groupId = "notification-group")
    public void listen(NotificationEvent event) {
        log.info("✅ Consumed notification for user: {}", event.getUserId());
        webSocketService.sendNotification(event);
    }
}
