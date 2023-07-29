package com.bms.bookmyshow.dtos;

import com.bms.bookmyshow.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetUserResponse {
    private Long id;
    private String name;
    private String email;
    public static GetUserResponse fromUser(User user){
        return new GetUserResponse(user.getId(), user.getName(), user.getEmail());
    }

}
