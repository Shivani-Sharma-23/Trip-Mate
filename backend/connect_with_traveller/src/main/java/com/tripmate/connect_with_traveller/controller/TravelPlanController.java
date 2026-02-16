package com.tripmate.connect_with_traveller.controller;

import com.tripmate.connect_with_traveller.entity.TravelPlan;
import com.tripmate.connect_with_traveller.service.TravelPlanService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/travel")
@RequiredArgsConstructor
public class TravelPlanController {

    private final TravelPlanService service;

    @PostMapping("/create")
    public TravelPlan create(
            @RequestBody TravelPlan request,
            HttpServletRequest httpRequest) {

        Long userId =
                (Long) httpRequest.getAttribute("userId");

        String originCountry =
                (String) httpRequest.getAttribute("originCountry");

        return service.createPlan(
                request, userId, originCountry);
    }
}
