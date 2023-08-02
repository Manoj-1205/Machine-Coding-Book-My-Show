package com.bms.bookmyshow.dtos;

import com.bms.bookmyshow.enums.SeatType;
import com.bms.bookmyshow.models.Seats;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateSeatRequest {
    private Integer rowNo;
    private Integer columnNo;
    private SeatType seatType;


    public Seats toSeats(){

        return Seats.builder()
                .rowNo(rowNo)
                .columnNo(columnNo)
                .seatType(seatType)
                .build();
    }
}
