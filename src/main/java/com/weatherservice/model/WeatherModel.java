package com.weatherservice.model;

import com.weatherservice.entity.CitiesEntity;
import lombok.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherModel {

    private String description;
   @NotNull(message = "temperature is required")
    private BigDecimal temperature;

    private BigDecimal feelsLike;

    private BigDecimal windSpeed;
    private CitiesEntity cities;
}
