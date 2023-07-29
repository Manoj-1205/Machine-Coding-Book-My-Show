package com.bms.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="shows")
@Builder
public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Double duration;

    @OneToMany
    private List<ShowSeat> showSeats=new ArrayList<>();
//    @ManyToOne
//    @JoinColumn(name="theater_id")
//    private Theater theater;
}
