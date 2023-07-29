package com.bms.bookmyshow.Services;

import com.bms.bookmyshow.Repositories.BookingRepository;
import com.bms.bookmyshow.dtos.CreateBookingRequest;
import com.bms.bookmyshow.models.Booking;
import com.bms.bookmyshow.models.Show;
import com.bms.bookmyshow.models.User;
import com.zaxxer.hikari.util.IsolationLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor

public class BookingService {
    private BookingRepository bookingRepository;
    private UserService userService;
    private ShowService showService;

//    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Transactional(isolation = Isolation.SERIALIZABLE)

    //Multiple people cannot book same seats at same time
    public Booking createBooking(CreateBookingRequest request){
        //Step1 - Get user through id
            //1b) If user is not present, throw error
        User user = userService.getUser(request.getUserId());
        //Step2 - Get Show using id
            //2b) If show not present, throw error
        Show show = showService.getShow(request.getShowId());
        //Step3 - Get showSeats using show seats ids
            //3b) id not present
            //3c) check seat status - availability
        //Step4 - Mark all the seats as blocked
        //Step5 - Calculate amount - Price calculation strategy
        //Step6 - Create and save booking
        return null;
    }
}
