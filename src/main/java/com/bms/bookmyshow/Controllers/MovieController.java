package com.bms.bookmyshow.Controllers;

import com.bms.bookmyshow.Services.MovieService;
import com.bms.bookmyshow.dtos.CreateMovieRequest;
import com.bms.bookmyshow.models.Movie;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class MovieController {
    private MovieService movieService;
    //CREATE MOVIE
    @PostMapping("/movie")
    public Movie createMovie(@RequestBody CreateMovieRequest request){
        Movie movie = Movie.builder()
                .name(request.getName())
                .rating(request.getRating())
                .features(request.getFeatures())
                .languages(request.getLanguages())
                .build();
        return movieService.createMovie(movie);
    }

    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable Long id){
        return movieService.getMovie(id);
    }
}
