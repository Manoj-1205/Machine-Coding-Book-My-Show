package com.bms.bookmyshow.Services;

import com.bms.bookmyshow.Exceptions.PaymentFailedException;
import com.bms.bookmyshow.Exceptions.ShowSeatNotFoundException;
import com.bms.bookmyshow.Exceptions.ShowSeatSoldOutException;
import com.bms.bookmyshow.Repositories.BookingRepository;
import com.bms.bookmyshow.Repositories.ShowSeatRepository;
import com.bms.bookmyshow.dtos.CreateBookingRequest;
import com.bms.bookmyshow.enums.BookingStatus;
import com.bms.bookmyshow.enums.PaymentProvider;
import com.bms.bookmyshow.enums.PaymentStatus;
import com.bms.bookmyshow.enums.SeatStatus;
import com.bms.bookmyshow.models.*;
import com.bms.bookmyshow.strategies.paymentStrategy.CashPaymentStrategy;
import com.bms.bookmyshow.strategies.paymentStrategy.PaymentProcessor;
import com.bms.bookmyshow.strategies.paymentStrategy.PaymentStrategy;
import com.zaxxer.hikari.util.IsolationLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class BookingService {
    private BookingRepository bookingRepository;
    private UserService userService;
    private ShowService showService;
    private SeatService seatService;
    private ShowSeatService showSeatService;
    private PaymentService paymentService;

//    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Transactional(isolation = Isolation.SERIALIZABLE)

    //Multiple people cannot book same seats at same time
    public Booking createBooking(CreateBookingRequest request) throws PaymentFailedException, ShowSeatNotFoundException {
        //Step1 - Get user through id
            //1b) If user is not present, throw error
        User user = userService.getUser(request.getUserId());
        //Step2 - Get Show using id
            //2b) If show not present, throw error
        Show show = showService.getShow(request.getShowId());
//        List<ShowSeat> showSeats = showSeatService.getShowSeats(show);
        System.out.println("Creating Booking for user "+user.getName()+ " for show "+show.getId()+" and seats");
        List<ShowSeat> showSeats = showSeatService.getShowSeats(show);
        for(Long id : request.getShowSeatId()){
            ShowSeat showSeat = showSeatService.getShowSeat(id);
            if(!showSeats.contains(showSeat)){
                throw new ShowSeatNotFoundException("Seat not found");
            }
            if(!showSeat.getSeatStatus().equals(SeatStatus.AVAILABLE))
                throw new ShowSeatSoldOutException("Selected seat sold out. Try selecting different seats");
        }
        for(Long id : request.getShowSeatId()){
            ShowSeat showSeat = showSeatService.getShowSeat(id);
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
            showSeatService.saveShowSeat(showSeat);
        }

        Integer numberOfSeats = request.getShowSeatId().size();
        Double ticketPrice = 200.0;
        Double totalAmount = numberOfSeats * ticketPrice;


        Booking booking = Booking.builder()
                .user(user)
                .show(show)
                .amount(totalAmount)
                .bookingStatus(BookingStatus.PAYMENT_PENDING)
                .build();

        Booking savedBooking = bookingRepository.save(booking);

        //STRATEGY
        PaymentProcessor paymentProcessor=new PaymentProcessor(new CashPaymentStrategy());
        Boolean paymentDone = paymentProcessor.pay(totalAmount);
        if(paymentDone){
            Payment payment = Payment.builder()
                    .booking(savedBooking)
                    .amount(totalAmount)
                    .paymentStatus(PaymentStatus.DONE)
                    .paymentProvider(request.getPaymentProvider())
                    .build();
            paymentService.savePayment(payment);
            for(Long id : request.getShowSeatId()){
                ShowSeat showSeat = showSeatService.getShowSeat(id);
                showSeat.setSeatStatus(SeatStatus.OCCUPIED);
                showSeatService.saveShowSeat(showSeat);
            }
            savedBooking.setBookingStatus(BookingStatus.CONFIRMED);
            bookingRepository.save(savedBooking);

        }
        else{
            for(Long id : request.getShowSeatId()){
                ShowSeat showSeat = showSeatService.getShowSeat(id);
                showSeat.setSeatStatus(SeatStatus.AVAILABLE);
                showSeatService.saveShowSeat(showSeat);
            }
            Payment payment = Payment.builder()
                    .booking(savedBooking)
                    .amount(totalAmount)
                    .paymentStatus(PaymentStatus.FAILED)
                    .paymentProvider(request.getPaymentProvider())
                    .build();
            paymentService.savePayment(payment);
            savedBooking.setBookingStatus(BookingStatus.FAILED);
            throw new PaymentFailedException("Payment Failed");
        }
//
        return bookingRepository.save(savedBooking);
        //Step3 - Get showSeats using show seats ids
            //3b) id not present
            //3c) check seat status - availability
        //Step4 - Mark all the seats as blocked
        //Step5 - Calculate amount - Price calculation strategy
        //Step6 - Create and save booking
//        return null;
    }
}
