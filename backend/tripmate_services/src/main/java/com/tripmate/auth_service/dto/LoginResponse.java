package com.tripmate.auth_service.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class LoginResponse {

    private String token;
    private Long userId;
    private String userEmail;
    private String originCountry;

}

