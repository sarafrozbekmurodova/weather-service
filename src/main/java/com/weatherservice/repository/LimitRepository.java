package com.weatherservice.repository;

import com.weatherservice.entity.LimitEntity;
import org.springframework.data.repository.CrudRepository;

public interface LimitRepository extends CrudRepository<LimitEntity, String> {
}
