package com.bms.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Theater extends BaseModel{
    private String name;
    private String address;

    @OneToMany
    private List<Hall> halls = new ArrayList<>();
    @OneToMany
    private List<Show> shows = new ArrayList<>();
}
