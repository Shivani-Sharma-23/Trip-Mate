package com.tripmate.auth_service.service.impl;


import com.tripmate.auth_service.dto.LoginRequest;
import com.tripmate.auth_service.dto.LoginResponse;
import com.tripmate.auth_service.entity.User;
import com.tripmate.auth_service.repository.UserRepository;
import com.tripmate.auth_service.config.JwtUtil;
import com.tripmate.auth_service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public User register(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public LoginResponse login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user);


        return LoginResponse.builder()
                .token(token)
                .userId(user.getId())
                .userEmail(user.getEmail())
                .originCountry(user.getOrigin_country())
                .build();
    }

    @Override
    public void deleteUser(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);
    }


}
