package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.PaymentProvider;
import com.bms.bookmyshow.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    private String reference;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private PaymentProvider paymentProvider;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
