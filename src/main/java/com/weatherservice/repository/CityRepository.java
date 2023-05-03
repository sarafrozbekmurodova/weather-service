package com.weatherservice.repository;

import com.weatherservice.entity.CitiesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<CitiesEntity, Integer> {
	
	public List<CitiesEntity> findAllByName(String name);
}
