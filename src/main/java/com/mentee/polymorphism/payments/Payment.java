package com.mentee.polymorphism.payments;

public abstract class Payment {

    protected String transactionId;
    protected double amount;
    protected String currency;
    private String email;

    // TODO: Constructor
    public Payment(String newTransactionId, Double newAmount, String newCurrency, String newEmail){
        transactionId = newTransactionId;
        amount = newAmount;
        currency = newCurrency;
        email = newEmail;
    }


    public String getEmail(){return email;}
    // Abstract methods
    public abstract boolean processPayment();
    public abstract String getPaymentType();

    // Concrete methods
    public double getAmount() {
        return amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void logTransaction() {
        System.out.println("Transaction " + transactionId + " | Amount: " + amount + " " + currency);
    }
}