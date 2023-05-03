package com.weatherservice.repository;

import com.weatherservice.entity.SubscriptionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository extends CrudRepository<SubscriptionEntity, String> {

    List<SubscriptionEntity> findAllByUserId(String companyId);

    Optional<SubscriptionEntity> findByUserIdAndPlanId(String companyId, String planId);
}
