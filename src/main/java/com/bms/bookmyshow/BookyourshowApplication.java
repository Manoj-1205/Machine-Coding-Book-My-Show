package com.bms.bookmyshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookyourshowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookyourshowApplication.class, args);
	}

}
