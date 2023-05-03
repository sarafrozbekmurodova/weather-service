package com.weatherservice.repository;

import com.weatherservice.entity.PlanEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlanRepository extends CrudRepository<PlanEntity,String> {
    Optional<PlanEntity> findByTitle(String title);
}
