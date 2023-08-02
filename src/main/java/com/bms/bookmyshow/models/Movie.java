package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.Language;
import com.bms.bookmyshow.enums.MovieFeature;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie extends BaseModel{
    private String name;
    private Double rating;

    //List of Enums
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Language> languages = new ArrayList<>();

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFeature> features=new ArrayList<>();
}
