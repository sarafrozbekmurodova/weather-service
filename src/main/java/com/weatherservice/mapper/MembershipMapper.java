package com.weatherservice.mapper;

import com.weatherservice.entity.LimitEntity;
import com.weatherservice.entity.PlanEntity;
import com.weatherservice.entity.SubscriptionEntity;
import com.weatherservice.model.CreatePlanModel;
import com.weatherservice.model.PlanWithLimitsModel;
import com.weatherservice.model.UserSubscriptionModel;
import org.mapstruct.Mapper;

@Mapper()
public interface MembershipMapper {


    PlanEntity mapCreatePlanModelToPlanEntity(CreatePlanModel createPlanModel);
    PlanWithLimitsModel mapPlanAndLimitsTogether(PlanEntity planEntity, LimitEntity limitEntity);

    UserSubscriptionModel mapEntitiesToCompanySubscriptionModel(PlanEntity planEntity,
                                                                SubscriptionEntity subscriptionEntity);

}
