package com.weatherservice.service;

import com.weatherservice.entity.WeatherEntity;
import com.weatherservice.model.WeatherModel;

public interface WeatherService {

    WeatherEntity addWeatherToCity(String cityId, WeatherModel model);
}
