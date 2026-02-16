package com.tripmate.auth_service.service;

import com.tripmate.auth_service.dto.LoginRequest;
import com.tripmate.auth_service.dto.LoginResponse;
import com.tripmate.auth_service.entity.User;

public interface AuthService {

    User register(User user);

    public LoginResponse login(String email, String password);

    void deleteUser(String email);
}
