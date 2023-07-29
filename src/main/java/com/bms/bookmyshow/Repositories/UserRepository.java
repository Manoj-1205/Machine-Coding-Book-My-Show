package com.bms.bookmyshow.Repositories;

import com.bms.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Data JPA talks to the database
public interface UserRepository extends JpaRepository<User, Long> {
}
