package com.tripmate.connect_with_traveller.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

@Entity
@Table(name = "travel_plan")
@Getter
@Setter
public class TravelPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    private String originCountry;
    private String destination;
    private Integer duration;
    private String travelStatus;
}

