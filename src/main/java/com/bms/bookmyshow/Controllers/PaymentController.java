package com.bms.bookmyshow.Controllers;

import com.bms.bookmyshow.models.Payment;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PaymentController {
    @PostMapping("/payment")
    public Payment makePayment(){

        return null;
    }
}
