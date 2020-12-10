package com.tg.themeparkride.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.tg.themeparkride.entity.ThemeParkRidesEntity;
import com.tg.themeparkride.repository.ThemeParkRidesRepository;

@RestController
public class ThemeParkRidesController {
    private final ThemeParkRidesRepository themeParkRidesRepository;

    public ThemeParkRidesController(ThemeParkRidesRepository themeParkRidesRepository) {
        this.themeParkRidesRepository = themeParkRidesRepository;
    }
    
    @GetMapping(value = "/")
    public String welcome() {
        return "<html><body><h1 style='text-align:center'>Welcome To Theme Park Rides</h1></body></html>";
    }


    @GetMapping(value = "/ride", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ThemeParkRidesEntity> getRides() {
        return themeParkRidesRepository.findAll();
    }

    @GetMapping(value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRidesEntity getRide(@PathVariable long id){
        return themeParkRidesRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
    }
    
    @PostMapping(value = "/ride", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRidesEntity createRide(@Valid @RequestBody ThemeParkRidesEntity themeParkRide) {
        return themeParkRidesRepository.save(themeParkRide);
    }

    @DeleteMapping(value = "/ride/{id}")
    public void deleteRide(@PathVariable long id){
        themeParkRidesRepository.deleteById(id);
    }
    
}

