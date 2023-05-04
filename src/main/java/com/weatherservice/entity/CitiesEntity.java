package com.weatherservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities")
public class CitiesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, length = 5)
    private String code;
    @OneToMany
    private Set<WeatherEntity> weather;

    @OneToMany(mappedBy = "cities")
    private Set<CountryEntity> countries;

    public CitiesEntity(String cityId) {
        this.code=cityId;
    }
}
