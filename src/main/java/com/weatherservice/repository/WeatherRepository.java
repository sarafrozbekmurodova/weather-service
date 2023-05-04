package com.weatherservice.repository;

import com.weatherservice.entity.WeatherEntity;
import org.springframework.data.repository.CrudRepository;

public interface WeatherRepository extends CrudRepository<WeatherEntity,String> {
}
