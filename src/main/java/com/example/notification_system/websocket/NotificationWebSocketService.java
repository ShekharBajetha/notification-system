package com.example.notification_system.websocket;

import com.example.notification_system.model.NotificationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationWebSocketService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void sendNotification(NotificationEvent event) {
        messagingTemplate.convertAndSend("/topic/notifications", event);
    }
}
