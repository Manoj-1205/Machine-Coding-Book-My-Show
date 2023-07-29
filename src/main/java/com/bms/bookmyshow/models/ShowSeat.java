package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.SeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity

public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show shows;

    @ManyToOne
    private Seat seat;

    @Enumerated
    private SeatStatus seatStatus;


}
