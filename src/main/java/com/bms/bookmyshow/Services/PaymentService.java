package com.bms.bookmyshow.Services;

import com.bms.bookmyshow.Repositories.PaymentRepository;
import com.bms.bookmyshow.models.Payment;
import com.bms.bookmyshow.strategies.paymentStrategy.CashPaymentStrategy;
import com.bms.bookmyshow.strategies.paymentStrategy.PaymentProcessor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {
    private PaymentRepository paymentRepository;
    public Payment savePayment(Payment payment){
        return paymentRepository.save(payment);

    }
}
