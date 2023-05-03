package com.weatherservice.controller;

import com.weatherservice.model.CreatePlanModel;
import com.weatherservice.model.PlanWithLimitsModel;
import com.weatherservice.model.SubscribeRequestModel;
import com.weatherservice.model.UserSubscriptionModel;
import com.weatherservice.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class MembershipController {
    private final MembershipService membershipService;
    @PostMapping("/plan")
    public ResponseEntity<PlanWithLimitsModel> createPlanModel(@RequestBody @Valid CreatePlanModel createPlanModel){
        var plan = membershipService.createPlan(createPlanModel);
        return ResponseEntity.ok(plan);
    }

    @GetMapping("/subscriptions/{userId}")
    public ResponseEntity<List<UserSubscriptionModel>> getAllUserSubscriptions(@PathVariable String userId){
        var subscriptions = membershipService.getAllUserSubscriptions(userId);
        return ResponseEntity.ok(subscriptions);
    }
    @PostMapping("/subscribe/{userId}")
    public ResponseEntity<Void> subscribeUser(@PathVariable String userId,
                                                 @RequestBody @Valid SubscribeRequestModel subscribeRequestModel){
        membershipService.subscribeUser(userId, subscribeRequestModel);
        return ResponseEntity.noContent().build();
    }

}
