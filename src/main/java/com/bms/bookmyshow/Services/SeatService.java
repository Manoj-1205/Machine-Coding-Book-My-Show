package com.bms.bookmyshow.Services;

import com.bms.bookmyshow.Repositories.SeatsRepository;
import com.bms.bookmyshow.models.Hall;
import com.bms.bookmyshow.models.Seats;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class SeatService {
    private SeatsRepository seatsRepository;
    public void saveSeats(List<Seats> hallSeats) {
        seatsRepository.saveAll(hallSeats);
    }

    public List<Seats> getHallSeats(Hall hall) {
        return seatsRepository.findByHall(hall);
    }
//    private SeatRepository seatRepository;
//    private HallService hallService;
//    public Seats createSeat(CreateSeatRequest request) {
//        Hall hall = hallService.getHall(request.getHallId());
//        if(hall==null){
//            throw new NoSuchElementException("Hall Not Found!!!");
//        }
//        Seats seat = Seats.builder()
//                .rowNo(request.getRowNo())
//                .columnNo(request.getColumnNo())
//                .seatType(SeatType.GOLD)
//                .hall(hall)
//                .build();
//        hall.getSeats().add(seat);
//
//        return seatRepository.save(seat);
//    }
}
