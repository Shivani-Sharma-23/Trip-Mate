package com.tripmate.auth_service.controller;

import com.tripmate.auth_service.config.JwtUtil;
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
    private final JwtUtil jwtUtil;


    @GetMapping("/api/secure")
    public ResponseEntity<String> secure() {
        System.out.println("SECURE ENDPOINT HIT");
        return ResponseEntity.ok("Access granted");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(
            @RequestHeader("Authorization") String header) {

        if (header == null || !header.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body("Invalid token");
        }

        String token = header.substring(7);
        String email = jwtUtil.extractUsername(token);

        authService.deleteUser(email);

        return ResponseEntity.ok("User deleted successfully");
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
