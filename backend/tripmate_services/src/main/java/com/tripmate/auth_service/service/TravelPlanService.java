package com.tripmate.auth_service.service;

import com.tripmate.auth_service.entity.TravelPlan;
import com.tripmate.auth_service.repository.TravelPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TravelPlanService {

    private final TravelPlanRepository travelPlanRepository;

    public TravelPlan createPlan(Long userId,
                                 String originCountry,
                                 TravelPlan request) {

        request.setUserId(userId);
        request.setOriginCountry(originCountry);
        request.setTravelStatus("ACTIVE");

        return travelPlanRepository.save(request);
    }
}
