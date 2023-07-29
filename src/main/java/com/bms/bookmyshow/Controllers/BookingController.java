package com.bms.bookmyshow.Controllers;

import com.bms.bookmyshow.Services.BookingService;
import com.bms.bookmyshow.dtos.CreateBookingRequest;
import com.bms.bookmyshow.models.Booking;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BookingController {
    private BookingService bookingService;
    //CREATE BOOKING
    @PostMapping("/booking")
    public Booking createBooking(@RequestBody CreateBookingRequest request){
        return bookingService.createBooking(request);
    }
}
