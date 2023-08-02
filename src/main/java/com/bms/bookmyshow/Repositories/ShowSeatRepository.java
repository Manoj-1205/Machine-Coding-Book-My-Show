package com.bms.bookmyshow.Repositories;

import com.bms.bookmyshow.models.Show;
import com.bms.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    public List<ShowSeat> findByShow(Show show);
}
