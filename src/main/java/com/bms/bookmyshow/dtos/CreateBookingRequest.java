package com.bms.bookmyshow.dtos;

import com.bms.bookmyshow.Services.PaymentService;
import com.bms.bookmyshow.enums.PaymentProvider;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateBookingRequest {
    private Long userId;
    private Long showId;
    private List<Long> showSeatId = new ArrayList<>();
    private PaymentProvider paymentProvider;

}
