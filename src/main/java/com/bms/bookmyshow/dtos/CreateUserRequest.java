package com.bms.bookmyshow.dtos;

import com.bms.bookmyshow.models.User;
import lombok.Data;

@Data

public class CreateUserRequest {
    private String name;
    private String email;
    private String password;

    public User toUser(){
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();



    }


}
