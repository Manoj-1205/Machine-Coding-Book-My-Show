package com.bms.bookmyshow.Repositories;

import com.bms.bookmyshow.models.Hall;
import com.bms.bookmyshow.models.Seats;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatsRepository extends JpaRepository<Seats, Long> {
    public List<Seats> findByHall(Hall hall);
}
