package com.tripmate.connect_with_traveller.service;

import com.tripmate.connect_with_traveller.entity.TravelPlan;
import com.tripmate.connect_with_traveller.repository.TravelPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TravelPlanService {

    private final TravelPlanRepository repository;

    public TravelPlan createPlan(
            TravelPlan request,
            Long userId,
            String originCountry) {

        TravelPlan plan = TravelPlan.builder()
                .userId(userId)
                .originCountry(originCountry)
                .destination(request.getDestination())
                .startDate(request.getStartDate())
                .duration(request.getDuration())
                .travelStatus("ACTIVE")
                .build();

        return repository.save(plan);
    }
}
