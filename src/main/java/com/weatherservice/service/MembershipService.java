package com.weatherservice.service;

import com.weatherservice.model.CreatePlanModel;
import com.weatherservice.model.PlanWithLimitsModel;
import com.weatherservice.model.SubscribeRequestModel;
import com.weatherservice.model.UserSubscriptionModel;

import java.util.List;

public interface MembershipService {
    PlanWithLimitsModel createPlan(CreatePlanModel createPlanModel);

    List<UserSubscriptionModel> getAllUserSubscriptions(String userId);

    void subscribeUser(String userId, SubscribeRequestModel subscribeRequestModel);

}
