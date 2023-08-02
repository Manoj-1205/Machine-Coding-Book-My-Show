package com.bms.bookmyshow.Services;

import com.bms.bookmyshow.Repositories.HallRepository;
import com.bms.bookmyshow.Repositories.ShowRepository;
import com.bms.bookmyshow.Repositories.ShowSeatRepository;
import com.bms.bookmyshow.dtos.CreateShowRequest;
import com.bms.bookmyshow.models.Hall;
import com.bms.bookmyshow.models.Movie;
import com.bms.bookmyshow.models.Show;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ShowService {
    ShowRepository showRepository;
    ShowSeatService showSeatService;
    HallService hallService;
    MovieService movieService;
    public Show createShow(CreateShowRequest request){
        //Task 1 -> Get Movie by ID by calling Movie Service

        Movie movie = movieService.getMovie(request.getMovieId());
//        if(movie==null)
//            throw new NoSuchElementException("Movie Not Found");
        Hall hall = hallService.getHall(request.getHallId());
        if(hall == null){
            throw new NoSuchElementException("Invalid Hall Id");
        }
        Show show = Show.builder()
                .hall(hall)
                .startTime(request.getStartTime())
                .duration(request.getDuration())
                .movie(movie)
                .build();
        Show savedShow = showRepository.save(show);
        showSeatService.saveShowSeats(savedShow);




        //Task 2 -> Get seats in Hall using HallId. Create showSeats using saved show and save the show again
        return showRepository.save(savedShow);
    }

    public Show getShow(Long id){

        return showRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Invalid ID"));
    }
}
