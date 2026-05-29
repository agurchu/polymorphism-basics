package com.mentee.polymorphism.payments;

public class CreditCardPayment extends Payment implements PaymentValidator, Refundable {

    private String cardNumber;
    private String cardType;

    // TODO: Constructor + implement all abstract + interface methods
    public CreditCardPayment(String transactionId, Double newAmount, String currency, String newCardNum, String newEmail){
        super(transactionId, newAmount, currency,newEmail);
        cardNumber = newCardNum;
        cardType =  "Credit Card";
    }
    public CreditCardPayment(String transactionId, int newAmount, String currency, String newCardNum, String newEmail){
        super(transactionId, (double) newAmount, currency,newEmail);
        cardNumber = newCardNum;
        cardType =  "Credit Card";
    }

    @Override
    public boolean processPayment(){
        System.out.println("Processing credit card...");
        return true;
    }

    @Override
    public boolean validate(){
        return cardNumber != null && cardNumber.length() == 16;
    }

    @Override
    public boolean refund(){return true;}
    @Override
    public String getPaymentType(){
        return cardType;
    }
}