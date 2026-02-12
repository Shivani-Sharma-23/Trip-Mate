package com.tripmate.auth_service.controller;

import com.tripmate.auth_service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthController {
    private final AuthService authService;

    @PostMapping("/customer/login")
    public ResponseEntity<?> customerLogin(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(
                authService.userLogin(request.getEmail(), request.getPassword())
        );
    }
}



