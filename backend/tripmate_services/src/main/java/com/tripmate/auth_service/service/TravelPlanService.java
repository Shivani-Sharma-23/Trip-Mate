package com.tripmate.auth_service.service;

import com.tripmate.auth_service.entity.TravelPlan;
import com.tripmate.auth_service.entity.User;
import com.tripmate.auth_service.repository.TravelPlanRepository;
import com.tripmate.auth_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TravelPlanService {

    private final TravelPlanRepository travelPlanRepository;
    private final UserRepository userRepository;

    public TravelPlan createPlan(Long userId,
                                 String originCountry,
                                 TravelPlan request) {

        request.setUserId(userId);
        request.setOriginCountry(originCountry);
        request.setTravelStatus("ACTIVE");

        TravelPlan savedPlan = travelPlanRepository.save(request);

        User user = userRepository.findById(userId)
                .orElseThrow();

        user.setTravelStatus("ACTIVE");
        userRepository.save(user);

        return savedPlan;
    }

    public void deactivatePlan(Long planId) {

        TravelPlan plan = travelPlanRepository.findById(planId)
                .orElseThrow();

        plan.setTravelStatus("INACTIVE");
        travelPlanRepository.save(plan);

        User user = userRepository.findById(plan.getUserId())
                .orElseThrow();

        user.setTravelStatus("INACTIVE");
        userRepository.save(user);
    }
}
