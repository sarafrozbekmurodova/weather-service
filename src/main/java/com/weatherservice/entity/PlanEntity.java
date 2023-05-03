package com.weatherservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "plan")
public class PlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "subTitle")
    private String subTitle;
    @Column(name = "pricePerYear")
    private Double pricePerYear;
    @Column(name = "pricePerMonth")
    private Double pricePerMonth;
    @Column(name = "isFree")
    private Boolean isFree;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "isActive")
    private Boolean isActive = false;
    @OneToOne
    @JoinColumn(name = "limitId")
    private LimitEntity limitId;
}
