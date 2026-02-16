package com.tripmate.auth_service.controller;

import com.tripmate.auth_service.dto.MatchedTravellerDTO;
import com.tripmate.auth_service.entity.Connection;
import com.tripmate.auth_service.service.ConnectionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connection")
@RequiredArgsConstructor
public class ConnectionController {

    private final ConnectionService connectionService;

    @GetMapping("/match/{userId}/{origin}/{destination}")
    public ResponseEntity<List<MatchedTravellerDTO>> getMatches(
            @RequestParam Long userId,
            @RequestParam String origin,
            @RequestParam String destination) {

        return ResponseEntity.ok(
                connectionService.findMatches(userId,origin, destination)
        );
    }
}

