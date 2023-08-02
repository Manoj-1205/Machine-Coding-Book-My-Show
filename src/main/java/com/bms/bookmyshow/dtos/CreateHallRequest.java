package com.bms.bookmyshow.dtos;

import com.bms.bookmyshow.Repositories.SeatsRepository;
import com.bms.bookmyshow.Services.SeatService;
import com.bms.bookmyshow.enums.MovieFeature;
import com.bms.bookmyshow.models.Hall;
import com.bms.bookmyshow.models.Seats;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

@AllArgsConstructor
public class CreateHallRequest {

    private String name;
    List<CreateSeatRequest> seats=new ArrayList<>();
//    List<MovieFeature> features=new ArrayList<>();



//    public Hall addHallSeats(Hall hall) {
//        List<Seats> hallSeats=new ArrayList<>();
//        for(CreateSeatRequest s : seats){
//            Seats seat =s.toSeats();
//            seat.setHall(hall);
//            hallSeats.add(seat);
//
//        }
//        seatService.saveSeats(hallSeats);
//        return hall;
//    }
}
