package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.PaymentProvider;
import com.bms.bookmyshow.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends BaseModel{
    private String reference;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private PaymentProvider paymentProvider;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @ManyToOne
    private Booking booking;
}
