package com.mentee.polymorphism.notification;

public interface Notifiable {
    boolean sendNotification();

    default void logNotification() {
        System.out.println("Notification logged at: " + java.time.LocalDateTime.now());
    }
}