package com.bms.bookmyshow.Exceptions;

public class PaymentFailedException extends Throwable {
    public PaymentFailedException(String payment_failed) {
        super(payment_failed);
    }
}
