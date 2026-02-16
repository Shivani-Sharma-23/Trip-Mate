package com.tripmate.connect_with_traveller.controller;

import com.tripmate.connect_with_traveller.entity.Connection;
import com.tripmate.connect_with_traveller.service.ConnectionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/connect")
@RequiredArgsConstructor
public class ConnectionController {

    private final ConnectionService service;

    @PostMapping("/send")
    public Connection send(
            @RequestParam Long receiverId,
            @RequestParam String currTravelCountry,
            HttpServletRequest request) {

        Long senderId =
                (Long) request.getAttribute("userId");

        String originCountry =
                (String) request.getAttribute("originCountry");

        return service.sendRequest(
                senderId,
                originCountry,
                receiverId,
                currTravelCountry
        );
    }
}
