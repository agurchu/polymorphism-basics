package com.mentee.polymorphism.notification;

public interface Loggable {
    void log();

    default String getLogLevel() {
        return "INFO";
    }
}