package com.bms.bookmyshow.strategies.paymentStrategy;

public class UPIPaymentStrategy implements PaymentStrategy{
    @Override
    public Boolean pay(Double amount) {
        System.out.println("UPI Payment : Payment successful");
        return true;
    }
}
