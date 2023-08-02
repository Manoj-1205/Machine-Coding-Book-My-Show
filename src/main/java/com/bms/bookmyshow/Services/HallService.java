package com.bms.bookmyshow.Services;

import com.bms.bookmyshow.Repositories.HallRepository;
import com.bms.bookmyshow.Repositories.SeatsRepository;
import com.bms.bookmyshow.dtos.CreateHallRequest;
import com.bms.bookmyshow.dtos.CreateSeatRequest;
import com.bms.bookmyshow.models.Hall;
import com.bms.bookmyshow.models.Seats;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class HallService {
    private HallRepository hallRepository;
    private SeatService seatService;
    public Hall createHall(CreateHallRequest request){
        Hall hall = Hall.builder()
                .name(request.getName())
//                .features(request.getFeatures())
                .build();
        hallRepository.save(hall);
        List<Seats> hallSeats=new ArrayList<>();
        for(CreateSeatRequest s : request.getSeats()){
            Seats seat =s.toSeats();
            seat.setHall(hall);
            hallSeats.add(seat);

        }
        seatService.saveSeats(hallSeats);


        return hall;

//        return savedHall;
    }

    public Hall getHall(Long id){
        return hallRepository.findById(id).orElse(null);
    }
}
