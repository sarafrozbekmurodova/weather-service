package com.weatherservice.service;

import com.weatherservice.entity.LimitEntity;
import com.weatherservice.entity.PlanEntity;
import com.weatherservice.entity.SubscriptionEntity;
import com.weatherservice.entity.User;
import com.weatherservice.exceptions.InvalidRequestException;
import com.weatherservice.exceptions.NotFoundRequestException;
import com.weatherservice.mapper.MembershipMapper;
import com.weatherservice.model.CreatePlanModel;
import com.weatherservice.model.PlanWithLimitsModel;
import com.weatherservice.model.SubscribeRequestModel;
import com.weatherservice.model.UserSubscriptionModel;
import com.weatherservice.repository.LimitRepository;
import com.weatherservice.repository.PlanRepository;
import com.weatherservice.repository.SubscriptionRepository;
import com.weatherservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MembershipServiceImpl implements MembershipService{
    private final PlanRepository planRepository;
    private final MembershipMapper membershipMapper;
    private final LimitRepository limitRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;

    private void checkIsTitleUsed(String title){
        var plan = planRepository.findByTitle(title);
        if (plan.isPresent())
            throw new InvalidRequestException("Title already used");
    }
    @Override
    public PlanWithLimitsModel createPlan(CreatePlanModel createPlanModel) {
        checkIsTitleUsed(createPlanModel.getTitle());
        var plan = membershipMapper.mapCreatePlanModelToPlanEntity(createPlanModel);
        var limits = new LimitEntity();
        limits.setCities(createPlanModel.getCities());
        limits.setWeatherData(createPlanModel.getWeatherData());
        var savedLimits = limitRepository.save(limits);
        plan.setLimitId(savedLimits);
        var savedPlan = planRepository.save(plan);
        return membershipMapper.mapPlanAndLimitsTogether(savedPlan, savedLimits);
    }

    @Override
    public List<UserSubscriptionModel> getAllUserSubscriptions(String userId) {
        var subscriptions = subscriptionRepository.findAllByUserId(userId);
        if (subscriptions.isEmpty())
            throw new NotFoundRequestException("No subscriptions", "0000");
        var userSubscriptions = new ArrayList<UserSubscriptionModel>();
        for (var subscription : subscriptions){
            userSubscriptions.add(membershipMapper.
                    mapEntitiesToCompanySubscriptionModel(getPlanById(subscription.getPlanId().getId()), subscription));
        }
        return userSubscriptions;
    }

    public PlanEntity getPlanById(String planId){
        var plan = planRepository.findById(planId);
        if(plan.isEmpty())
            throw new NotFoundRequestException("No such plan", "0000");
        return plan.get();
    }
    private SubscriptionEntity getActiveSubscriptionByUserId(String userId){
        var subscriptions = subscriptionRepository.
                findAllByUserId(userId);
        SubscriptionEntity activeSub = null;
        if (subscriptions.isEmpty())
            return null;
        for (var sub : subscriptions){
            if (sub.getCurrentPeriodEnd() == null)
                activeSub = sub;
            else if (sub.getCurrentPeriodEnd().compareTo(LocalDate.now()) > 0 && sub.getCancelledAt() == null)
                activeSub = sub;
        }
        return activeSub;
    }

    @Override
    public void subscribeUser(String userId, SubscribeRequestModel subscribeRequestModel) {
        var user=userRepository.findById(userId);
        var activeSubscription = getActiveSubscriptionByUserId(userId);
        if (activeSubscription != null && activeSubscription.getCancelledAt() == null){
            if (activeSubscription.getCurrentPeriodEnd() == null)
                activeSubscription.setCurrentPeriodEnd(LocalDate.now());
            activeSubscription.setCancelledAt(LocalDate.now());
            subscriptionRepository.save(activeSubscription);
        }
        var plan = getPlanById(subscribeRequestModel.getPlanId());
        SubscriptionEntity subscription;
        if(plan.getTitle().equals("DEFAULT")) {
            subscription = subscriptionRepository.findByUserIdAndPlanId(userId, plan.getId()).orElseGet(SubscriptionEntity::new);
            subscription.setCancelledAt(null);
        }
        else
            subscription = new SubscriptionEntity();
        if (user.isPresent()) {
            subscription.setUserId(user.get());
            subscription.setPlanId(plan);
        }
        subscription.setCurrentPeriodStart(LocalDate.now());
        LocalDate endDate = null;
        if (!plan.getIsFree()){
            var date = LocalDate.now();
            var day = date.getDayOfMonth();
            var month = date.getMonth().getValue();
            var year = date.getYear();
            if (subscribeRequestModel.getIsMonths()) {
                if (month < 12)
                    month++;
                else {
                    year++;
                    month = 1;
                }
            }
            else {
                year++;
            }
            endDate = LocalDate.of(year, month, day);
        }
        subscription.setCurrentPeriodEnd(endDate);
        subscriptionRepository.save(subscription);
    }
}
