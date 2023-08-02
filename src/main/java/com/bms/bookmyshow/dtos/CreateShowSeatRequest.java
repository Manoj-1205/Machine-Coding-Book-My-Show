package com.bms.bookmyshow.dtos;

import com.bms.bookmyshow.enums.SeatType;
import lombok.Data;

@Data
public class CreateShowSeatRequest {
    private Integer rowNo;
    private Integer columnNo;
    private SeatType seatType;
}
