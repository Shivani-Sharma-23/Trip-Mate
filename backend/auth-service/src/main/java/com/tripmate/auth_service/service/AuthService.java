package com.tripmate.auth_service.service;


import com.tripmate.auth_service.config.JwtUtil;
import com.tripmate.auth_service.entity.User;
import com.tripmate.auth_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepo;

    public String userLogin(String email, String password) {
        User user = userRepo.findByCustomerEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getUserPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return JwtUtil.generateToken(email, "USER");
    }

}
