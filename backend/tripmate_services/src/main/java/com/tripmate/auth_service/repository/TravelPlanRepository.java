package com.tripmate.auth_service.repository;

import com.tripmate.auth_service.dto.MatchedTravellerDTO;
import com.tripmate.auth_service.entity.TravelPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TravelPlanRepository
        extends JpaRepository<TravelPlan, Long> {

    // 🔹 Fetch plan of a specific user
    Optional<TravelPlan> findByUserId(Long userId);

    // 🔹 Match travellers by destination
    List<TravelPlan> findByDestinationAndTravelStatus(
            String destination,
            String travelStatus
    );

    // 🔹 Match travellers by origin country
    List<TravelPlan> findByOriginCountryAndTravelStatus(
            String originCountry,
            String travelStatus
    );

    // 🔹 Active travellers only
    List<TravelPlan> findByTravelStatus(String travelStatus);





}
