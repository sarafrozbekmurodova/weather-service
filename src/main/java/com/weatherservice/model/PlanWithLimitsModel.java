package com.weatherservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanWithLimitsModel {
    private String id;
    private String title;
    private String subTitle;
    private Double pricePerYear;
    private Double pricePerMonth;
    private Boolean isFree;
    private Double discount;
    private int cities;
    private Boolean weatherData;
    private Boolean isActive;
}
