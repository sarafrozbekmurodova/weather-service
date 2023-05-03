package com.weatherservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSubscriptionModel {

    private String planId;
    private String title;
    private String subTitle;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private LocalDate cancelledAt;
}
