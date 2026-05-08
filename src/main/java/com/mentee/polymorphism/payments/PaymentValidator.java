package com.mentee.polymorphism.payments;

public interface PaymentValidator {
    boolean validate();

    // Default method
    default void printValidationStatus(boolean isValid) {
        System.out.println("Validation " + (isValid ? "PASSED" : "FAILED"));
    }
}