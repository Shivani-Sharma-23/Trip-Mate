package com.tripmate.auth_service.controller;

import com.tripmate.auth_service.dto.LoginRequest;
import com.tripmate.auth_service.entity.User;
import com.tripmate.auth_service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/api/secure")
    public ResponseEntity<String> secure() {
        System.out.println("SECURE ENDPOINT HIT");
        return ResponseEntity.ok("Access granted");
    }


    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        return ResponseEntity.ok(authService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = authService.login(request);
        return ResponseEntity.ok(token);
    }


}
