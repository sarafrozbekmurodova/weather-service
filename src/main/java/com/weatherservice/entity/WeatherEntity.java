package com.weatherservice.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "weather")
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "description")
    private String description;
    @Column(name = "temperature", nullable = false)
    private BigDecimal temperature;
    @Column(name = "feelsLike")
    private BigDecimal feelsLike;
    @Column(name = "windSpeed")
    private BigDecimal windSpeed;
}
