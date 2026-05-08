package com.mentee.polymorphism.notification;

public class PushNotification extends Notification implements Notifiable {

    private String deviceToken;

    public PushNotification(String notificationId, String recipient, String message, String deviceToken) {
        super(notificationId, recipient, message);
        this.deviceToken = deviceToken;
    }

    @Override
    public boolean send() {
        System.out.println("Sending Push Notification to device: " + deviceToken.substring(0, 8) + "...");
        markAsSent();
        return true;
    }

    @Override
    public String getNotificationType() {
        return "Push";
    }

    @Override
    public boolean sendNotification() {
        return send();
    }
}