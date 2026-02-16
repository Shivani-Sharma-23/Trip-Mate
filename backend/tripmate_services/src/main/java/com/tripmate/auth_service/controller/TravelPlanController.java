package com.tripmate.auth_service.controller;

import com.tripmate.auth_service.entity.TravelPlan;
import com.tripmate.auth_service.service.TravelPlanService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/travel-plan")
@RequiredArgsConstructor
public class TravelPlanController {

    private final TravelPlanService travelPlanService;


    @PostMapping("/create/{userId}/{originCountry}")
    public ResponseEntity<TravelPlan> createPlan(
            @PathVariable Long userId,
            @PathVariable String originCountry,
            @RequestBody TravelPlan request) {

        TravelPlan savedPlan =
                travelPlanService.createPlan(userId, originCountry, request);

        return ResponseEntity.ok(savedPlan);
    }

    @PutMapping("/deactivate/{planId}")
    public ResponseEntity<String> deactivatePlan(@PathVariable Long planId) {

        travelPlanService.deactivatePlan(planId);
        return ResponseEntity.ok("Travel plan deactivated successfully");
    }
}
