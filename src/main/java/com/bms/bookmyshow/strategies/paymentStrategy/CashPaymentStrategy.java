package com.bms.bookmyshow.strategies.paymentStrategy;

public class CashPaymentStrategy implements PaymentStrategy{

    @Override
    public Boolean pay(Double amount) {
        System.out.println("Cash payment : Payment successful");
        return true;
    }
}
