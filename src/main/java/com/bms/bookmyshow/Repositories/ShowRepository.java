package com.bms.bookmyshow.Repositories;

import com.bms.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
}
