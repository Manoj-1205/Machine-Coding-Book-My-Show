package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "booking")
public class Booking extends BaseModel{
    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> seats=new ArrayList<>();
    private Double amount;
    private Date bookedAt;

    @Enumerated
    private BookingStatus bookingStatus;

    @OneToMany
    private List<Payment> payments=new ArrayList<>();

}
