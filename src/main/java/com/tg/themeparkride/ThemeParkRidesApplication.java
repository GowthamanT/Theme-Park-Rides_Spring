package com.tg.themeparkride;

import com.tg.themeparkride.entity.ThemeParkRidesEntity;
import com.tg.themeparkride.repository.ThemeParkRidesRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ThemeParkRidesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThemeParkRidesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner sampleData(ThemeParkRidesRepository repository) {
		return (args) -> {
			repository.save(new ThemeParkRidesEntity("Rollercoaster", "Train ride that speeds you along with Excitement", 5, 3));
		    repository.save(new ThemeParkRidesEntity("Log flume", "Boat ride with plenty of splashes.", 3, 2));
		    repository.save(new ThemeParkRidesEntity("Teacups", "Spinning ride in a giant tea-cup.", 2, 4));
	    };
	}

}
