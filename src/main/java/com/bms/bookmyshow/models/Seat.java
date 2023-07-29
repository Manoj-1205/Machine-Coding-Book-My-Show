package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel {
    private Integer rowNo;
    private Integer columnNo;
    @Enumerated
    private SeatType seatType;
}
