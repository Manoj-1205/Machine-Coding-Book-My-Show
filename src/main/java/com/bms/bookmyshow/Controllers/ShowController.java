package com.bms.bookmyshow.Controllers;

import com.bms.bookmyshow.Services.ShowService;
import com.bms.bookmyshow.dtos.CreateShowRequest;
import com.bms.bookmyshow.models.Show;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ShowController {
    ShowService showService;
    //CREATE
    @PostMapping("/show")
    public Show createShow(@RequestBody  CreateShowRequest request){

        return showService.createShow(request);
    }

    @GetMapping("/show/{id}")
    public Show readShow(@PathVariable Long id){

        return showService.getShow(id) ;
    }

}

//GET API

//CREATE API