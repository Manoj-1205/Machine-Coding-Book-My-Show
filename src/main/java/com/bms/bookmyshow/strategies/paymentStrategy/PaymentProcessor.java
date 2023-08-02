package com.bms.bookmyshow.strategies.paymentStrategy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PaymentProcessor{
    private PaymentStrategy strategy;
    public Boolean pay(Double amount){
        return strategy.pay(amount);
    }
}
