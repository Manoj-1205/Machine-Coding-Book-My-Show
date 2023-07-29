package com.bms.bookmyshow.Services;

import com.bms.bookmyshow.Repositories.MovieRepository;
import com.bms.bookmyshow.models.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService {
    private MovieRepository movieRepository;
    public Movie createMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie getMovie(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
}
