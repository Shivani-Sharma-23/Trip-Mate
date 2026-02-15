package com.tripmate.auth_service.service;

import com.tripmate.auth_service.dto.LoginRequest;
import com.tripmate.auth_service.entity.User;

public interface AuthService {

    User register(User user);

    String login(LoginRequest request);
}
