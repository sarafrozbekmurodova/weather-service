package com.weatherservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubscribeRequestModel {

    @NotNull(message = "planId is required")
    private String planId;
    @NotNull(message = "isMonth is required")
    private Boolean isMonths;
}
