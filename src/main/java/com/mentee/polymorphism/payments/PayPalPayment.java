package com.mentee.polymorphism.payments;

public class PayPalPayment extends Payment implements PaymentValidator {

//    private String email;
     private String cardType;
    // TODO: Constructor + implement all abstract + interface methods
    public PayPalPayment(String transactionId, Double newAmount, String currency, String newEmail){
        super(transactionId,newAmount, currency, newEmail);
        cardType = "PayPal";
    }
    @Override
    public boolean processPayment(){
        System.out.println("Processing credit card...");
        return true;
    }

    @Override
    public boolean validate(){
        return this.getEmail() != null && this.getEmail().contains("@");
    }

//    @Override
//    public boolean refund(){return true;}
    @Override
    public String getPaymentType(){
        return cardType;
    }
}