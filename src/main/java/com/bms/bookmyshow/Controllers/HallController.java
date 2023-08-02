package com.bms.bookmyshow.Controllers;

import com.bms.bookmyshow.Repositories.SeatsRepository;
import com.bms.bookmyshow.Services.HallService;
import com.bms.bookmyshow.Services.SeatService;
import com.bms.bookmyshow.dtos.CreateHallRequest;
import com.bms.bookmyshow.models.Hall;
import com.bms.bookmyshow.models.Seats;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class HallController {
    private HallService hallService;
    private SeatService seatService;
    @PostMapping("/hall")
    public Hall createHall(@RequestBody CreateHallRequest request){

        return hallService.createHall(request);
    }

    @GetMapping("/hall/{id}")
    public Hall getHall(@PathVariable Long id){
        return hallService.getHall(id);
    }

    @GetMapping("/hall/{id}/seats")
    public List<Seats> getHallSeats(@PathVariable Long id){
        Hall hall = hallService.getHall(id);
        return seatService.getHallSeats(hall);
    }
}
