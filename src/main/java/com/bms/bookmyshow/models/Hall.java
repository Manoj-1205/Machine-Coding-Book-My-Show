package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.MovieFeature;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hall extends BaseModel{
    private String name;
    @OneToMany(mappedBy = "hall", cascade = CascadeType.PERSIST)
    private List<Seats> seats=new ArrayList<>();

//    @Enumerated(EnumType.STRING)
//    @ElementCollection
//    List<MovieFeature> features=new ArrayList<>();

}
