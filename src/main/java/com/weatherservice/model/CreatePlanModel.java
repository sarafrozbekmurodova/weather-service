package com.weatherservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePlanModel {

    @NotNull(message = "title is required")
    private String title;
    @NotNull(message = "subTitle is required")
    private String subTitle;
    @NotNull(message = "pricePerYear is required")
    private Double pricePerYear;
    @NotNull(message = "pricePerMonth is required")
    private Double pricePerMonth;
    @NotNull(message = "isFree is required")
    private Boolean isFree;
    @NotNull(message = "discount is required")
    private Double discount;
    private int cities;
    @NotNull(message = "accountingPage is required")
    private Boolean weatherData;
}
