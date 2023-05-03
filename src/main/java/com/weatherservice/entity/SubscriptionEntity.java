package com.weatherservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subscription")
public class SubscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;
    @Column(name = "currentPeriodStart")
    private LocalDate currentPeriodStart;
    @Column(name = "currentPeriodEnd")
    private LocalDate currentPeriodEnd;
    @Column(name = "cancelledAt")
    private LocalDate cancelledAt;
    @ManyToOne
    @JoinColumn(name = "planId")
    private PlanEntity planId;
}
