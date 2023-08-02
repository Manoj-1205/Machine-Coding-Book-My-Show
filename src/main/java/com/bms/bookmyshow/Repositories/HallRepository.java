package com.bms.bookmyshow.Repositories;

import com.bms.bookmyshow.models.Hall;
import com.bms.bookmyshow.models.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {

}
