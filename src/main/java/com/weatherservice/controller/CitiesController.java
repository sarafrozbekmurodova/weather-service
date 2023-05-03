package com.weatherservice.controller;

import com.weatherservice.entity.CitiesEntity;
import com.weatherservice.repository.CityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CitiesController {
    CityRepository cityRepository;
    @GetMapping("/cities/list")
    public List<CitiesEntity> listAll(String name) {
        return cityRepository.findAllByName(name);
    }

    @PostMapping("/cities/save")
    public String save(@RequestBody CitiesEntity city) {
        CitiesEntity savedCountry = cityRepository.save(city);
        return String.valueOf(savedCountry.getId());
    }
}
