package com.mentee.polymorphism.notification;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotificationTest {

    @Test
    void testEmailNotification() {
        Notification email = new EmailNotification(
                "NOT-001",
                "john@example.com",
                "Welcome to our platform!",
                "Welcome Email"
        );

        assertEquals("john@example.com", email.getRecipient());
        assertEquals("Email", email.getNotificationType());
        assertFalse(email.isSent());

        boolean sent = email.send();
        assertTrue(sent);
        assertTrue(email.isSent());
    }

    @Test
    void testPushNotification() {
        Notification push = new PushNotification(
                "NOT-002",
                "user123",
                "You have a new message!",
                "d8f7a9b2c3e4f5g6h7i8j9k0l1m2n3o4p5"
        );

        assertEquals("Push", push.getNotificationType());

        boolean result = push.send();
        assertTrue(result);
    }

    @Test
    void testPolymorphicBehavior() {
        Notification[] notifications = {
                new EmailNotification("NOT-101", "alice@example.com", "Hello Alice", "Greeting"),
                new PushNotification("NOT-102", "device456", "New update available!", "token-xyz-789"),
                new EmailNotification("NOT-103", "bob@example.com", "Your order is ready", "Order Status")
        };

        for (Notification notification : notifications) {
            assertNotNull(notification.getRecipient());
            assertNotNull(notification.getNotificationType());
            assertFalse(notification.isSent()); // initially not sent

            // Runtime polymorphism - calling abstract method via superclass reference
            boolean sent = notification.send();
            assertTrue(sent);
            assertTrue(notification.isSent());

            notification.markAsSent(); // concrete method
        }
    }

    @Test
    void testInterfacePolymorphism() {
        Notifiable emailNotifiable = new EmailNotification(
                "NOT-201", "test@email.com", "Test message", "Test Subject"
        );

        Loggable emailLoggable = new EmailNotification(
                "NOT-202", "log@example.com", "Log test", "Log Subject"
        );

        assertTrue(emailNotifiable.sendNotification());
        emailNotifiable.logNotification();

        emailLoggable.log();
        assertEquals("INFO", emailLoggable.getLogLevel());
    }

    @Test
    void testMultipleInterfacesOnSameObject() {
        EmailNotification email = new EmailNotification(
                "NOT-301", "multi@example.com", "Multi interface test", "Multiple"
        );

        // Same object implementing multiple interfaces + abstract class
        assertTrue(email instanceof Notification);
        assertTrue(email instanceof Notifiable);
        assertTrue(email instanceof Loggable);

        assertTrue(email.sendNotification());
        email.log();
    }

    @Test
    void testNotificationTypes() {
        Notification email = new EmailNotification("E1", "e@test.com", "msg", "subj");
        Notification push = new PushNotification("P1", "dev123", "msg", "token123");

        assertEquals("Email", email.getNotificationType());
        assertEquals("Push", push.getNotificationType());
    }

    @Test
    void testMessageAndRecipientAccess() {
        String message = "This is a test notification message";
        String recipient = "recipient@test.com";

        Notification notification = new EmailNotification("NOT-TEST", recipient, message, "Test");

        assertEquals(recipient, notification.getRecipient());
        assertEquals(message, notification.getMessage());
    }
}