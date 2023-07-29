package com.bms.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
//@Table(name="city")
public class City extends BaseModel{
    private String name;

    //One-to-many relationship
    @OneToMany
    private List<Theater> theaters = new ArrayList<>();

}
