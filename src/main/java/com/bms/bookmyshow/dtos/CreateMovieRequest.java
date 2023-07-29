package com.bms.bookmyshow.dtos;

import com.bms.bookmyshow.enums.Language;
import com.bms.bookmyshow.enums.MovieFeature;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateMovieRequest {
    private String name;
    private Double rating;
    private List<Language> languages = new ArrayList<>();
    private List<MovieFeature> features=new ArrayList<>();

}
