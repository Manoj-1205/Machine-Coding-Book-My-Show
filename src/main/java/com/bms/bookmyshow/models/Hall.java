package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity

public class Hall extends BaseModel{
    private String name;
    @OneToMany
    private List<Seat> seats=new ArrayList<>();

    @Enumerated
    @ElementCollection
    List<MovieFeature> features=new ArrayList<>();

}
