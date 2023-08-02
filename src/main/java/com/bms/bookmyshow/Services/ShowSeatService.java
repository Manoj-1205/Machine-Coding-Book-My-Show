package com.bms.bookmyshow.Services;

import com.bms.bookmyshow.Repositories.SeatsRepository;
import com.bms.bookmyshow.Repositories.ShowSeatRepository;
import com.bms.bookmyshow.enums.SeatStatus;
import com.bms.bookmyshow.models.Hall;
import com.bms.bookmyshow.models.Seats;
import com.bms.bookmyshow.models.Show;
import com.bms.bookmyshow.models.ShowSeat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ShowSeatService {
    private ShowSeatRepository showSeatRepository;
    private SeatService seatService;
    public List<ShowSeat> saveShowSeats(Show show){
        Hall hall = show.getHall();

        List<Seats> seats = seatService.getHallSeats(hall);
        List<ShowSeat> showSeats = new ArrayList<>();
        for(Seats seat : seats){
            showSeats.add(ShowSeat.builder()
                    .show(show)
                    .seat(seat)
                    .seatStatus(SeatStatus.AVAILABLE)
                    .build()
            );
        }
        return showSeatRepository.saveAll(showSeats);
    }

    public ShowSeat saveShowSeat(ShowSeat showSeat){
        return showSeatRepository.save(showSeat);
    }

    public List<ShowSeat> getShowSeats(Show show){
        return showSeatRepository.findByShow(show);
    }

    public ShowSeat getShowSeat(Long id){
        return showSeatRepository.findById(id).orElseThrow(() ->  new NoSuchElementException("Show Seat Not found"));
    }
}
