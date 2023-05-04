package com.weatherservice.service;

import com.weatherservice.entity.WeatherEntity;
import com.weatherservice.model.WeatherModel;
import com.weatherservice.repository.CityRepository;
import com.weatherservice.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService{
   private final CityRepository cityRepository;
   private final WeatherRepository weatherRepository;

    @Override
    public WeatherEntity addWeatherToCity(String cityId, WeatherModel model){
        var city=cityRepository.findById(cityId);

        WeatherEntity entity=new WeatherEntity();
        entity.setDescription(model.getDescription());
        entity.setTemperature(model.getTemperature());
        entity.setFeelsLike(model.getFeelsLike());
        entity.setWindSpeed(model.getWindSpeed());
        weatherRepository.save(entity);
        return entity;
    }


}
