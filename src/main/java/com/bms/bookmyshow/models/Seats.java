package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Seats extends BaseModel {

    @ManyToOne
    @JsonIgnore
    private Hall hall;
    private Integer rowNo;
    private Integer columnNo;
    @Enumerated
    private SeatType seatType;

}

