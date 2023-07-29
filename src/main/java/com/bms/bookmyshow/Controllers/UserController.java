package com.bms.bookmyshow.Controllers;

import com.bms.bookmyshow.Services.UserService;
import com.bms.bookmyshow.dtos.CreateUserRequest;
import com.bms.bookmyshow.dtos.GetUserResponse;
import com.bms.bookmyshow.models.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
    UserService userService;
    @PostMapping("/user")
    public GetUserResponse createUser(@RequestBody CreateUserRequest request){
        System.out.println("Got Request for "+request.getEmail()+" with Password "+request.getPassword());
        User user = userService.createUser(request.toUser());
        return GetUserResponse.fromUser(user);
    }

    @GetMapping("/user/{id}")
    public User user(@PathVariable Long id){
        return userService.getUser(id);
    }

}

//Create User

