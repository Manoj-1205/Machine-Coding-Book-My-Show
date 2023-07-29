package com.bms.bookmyshow.Services;

import com.bms.bookmyshow.Repositories.UserRepository;
import com.bms.bookmyshow.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;
    public User createUser(User user){
        System.out.println("Getting response in service for User : "+user.getName());
        //Save the incoming user
       return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User Not found"));
    }
}
