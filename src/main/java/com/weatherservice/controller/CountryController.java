package com.weatherservice.controller;

import com.weatherservice.entity.CitiesEntity;
import com.weatherservice.entity.CountryEntity;
import com.weatherservice.model.CountryDto;
import com.weatherservice.repository.CountryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class CountryController {
    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/country/list_by_cities/{id}")
    public List<CountryDto> listByCity(@PathVariable("id") String cityId,
                                       @RequestHeader("userId") Long userId) {
        List<CountryEntity> listCountries = countryRepository.findAllByCitiesAndName(new CitiesEntity(cityId));
        List<CountryDto> result = new ArrayList<>();

        for (CountryEntity country : listCountries) {
            result.add(new CountryDto(country.getId(), country.getName()));
        }

        return result;
    }

    @PostMapping("/countries/save")
    public String save(@RequestBody CountryEntity country) {
        CountryEntity savedCountry = countryRepository.save(country);
        return String.valueOf(savedCountry.getId());
    }
}
