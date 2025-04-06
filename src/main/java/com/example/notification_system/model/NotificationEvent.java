package com.example.notification_system.model;

public class NotificationEvent {
    private String userId;
    private String message;
    private String timestamp;

    public String getTimestamp() {
        return timestamp;
    }

    public NotificationEvent() {
    }

    public NotificationEvent(String userId, String message, String timestamp) {
        this.userId = userId;
        this.message = message;
        this.timestamp = timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
