package com.mentee.polymorphism.notification;

/**
 * Abstract class for Notification System
 */
public abstract class Notification {

    protected String notificationId;
    protected String recipient;
    protected String message;
    protected boolean isSent;

    public Notification(String notificationId, String recipient, String message) {
        this.notificationId = notificationId;
        this.recipient = recipient;
        this.message = message;
        this.isSent = false;
    }

    // Abstract methods
    public abstract boolean send();
    public abstract String getNotificationType();

    // Concrete methods
    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSent() {
        return isSent;
    }

    public void markAsSent() {
        this.isSent = true;
        System.out.println(getNotificationType() + " notification sent to " + recipient);
    }
}