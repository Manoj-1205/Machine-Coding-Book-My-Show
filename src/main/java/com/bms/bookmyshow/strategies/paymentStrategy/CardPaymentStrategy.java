package com.bms.bookmyshow.strategies.paymentStrategy;

import com.bms.bookmyshow.Exceptions.InsufficientBalanceException;

public class CardPaymentStrategy implements PaymentStrategy {
    private Double bankBalance = 1000.0;
    @Override
    public Boolean pay(Double amount) {
        System.out.println("Woohoo!! 5% Discount on Card payment.");
        double totalAmount=amount * (0.05);
        System.out.println("Total amount : "+totalAmount);
        if(totalAmount > bankBalance){
            return false;
        }
        System.out.println("Card payment : Payment successful");
        return true;
    }
}
