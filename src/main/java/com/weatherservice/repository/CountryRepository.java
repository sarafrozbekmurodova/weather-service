package com.weatherservice.repository;


import com.weatherservice.entity.CitiesEntity;
import com.weatherservice.entity.CountryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<CountryEntity, Integer> {
	public List<CountryEntity> findAllByCitiesAndName(CitiesEntity cities);
}
