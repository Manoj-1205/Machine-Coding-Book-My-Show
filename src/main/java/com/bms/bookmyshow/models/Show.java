package com.bms.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="shows")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Double duration;

    @ManyToOne
    @JsonIgnore
    private Hall hall;

    @OneToMany
    private List<ShowSeat> showSeats=new ArrayList<>();
//    @ManyToOne
//    @JoinColumn(name="theater_id")
//    private Theater theater;
}
