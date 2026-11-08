package com.example.ride_sharing_app.service;

import com.example.ride_sharing_app.dto.NotificationMessage;

public class NotificationService {
    public void send(NotificationMessage message) {
        System.out.println("[Notification] to=" + message.getTo() + " subject=" + message.getSubject() + " body="
                + message.getBody());
    }
}
