package com.weatherservice.mapper;

import com.weatherservice.entity.LimitEntity;
import com.weatherservice.entity.PlanEntity;
import com.weatherservice.entity.SubscriptionEntity;
import com.weatherservice.model.CreatePlanModel;
import com.weatherservice.model.PlanWithLimitsModel;
import com.weatherservice.model.UserSubscriptionModel;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class MembershipMapperImpl implements MembershipMapper{



    @Override
    public PlanEntity mapCreatePlanModelToPlanEntity(CreatePlanModel createPlanModel) {
        var plan = new PlanEntity();
        plan.setTitle(createPlanModel.getTitle());
        plan.setSubTitle(createPlanModel.getSubTitle());
        plan.setPricePerYear(createPlanModel.getPricePerYear());
        plan.setPricePerMonth(createPlanModel.getPricePerMonth());
        plan.setIsFree(createPlanModel.getIsFree());
        plan.setDiscount(createPlanModel.getDiscount());
        return plan;
    }

    @Override
    public PlanWithLimitsModel mapPlanAndLimitsTogether(PlanEntity planEntity, LimitEntity limitEntity) {
        PlanWithLimitsModel planWithLimits = new PlanWithLimitsModel();
        planWithLimits.setId(planEntity.getId());
        planWithLimits.setTitle(planEntity.getTitle());
        planWithLimits.setSubTitle(planEntity.getSubTitle());
        planWithLimits.setPricePerMonth(planEntity.getPricePerMonth());
        planWithLimits.setPricePerYear(planEntity.getPricePerYear());
        planWithLimits.setIsFree(planEntity.getIsFree());
        planWithLimits.setDiscount(planEntity.getDiscount());
        planWithLimits.setCities(limitEntity.getCities());
        planWithLimits.setWeatherData(limitEntity.getWeatherData());
        planWithLimits.setIsActive(planEntity.getIsActive());
        return planWithLimits;
    }

    @Override
    public UserSubscriptionModel mapEntitiesToCompanySubscriptionModel(PlanEntity planEntity,
                                                                       SubscriptionEntity subscriptionEntity) {
        var userSubscriptionModel = new UserSubscriptionModel();
        userSubscriptionModel.setPlanId(planEntity.getId());
        userSubscriptionModel.setTitle(planEntity.getTitle());
        userSubscriptionModel.setSubTitle(planEntity.getSubTitle());
        userSubscriptionModel.setPeriodStart(subscriptionEntity.getCurrentPeriodStart());
        userSubscriptionModel.setPeriodEnd(subscriptionEntity.getCurrentPeriodEnd());
        userSubscriptionModel.setCancelledAt(subscriptionEntity.getCancelledAt());
        return userSubscriptionModel;
    }

}

