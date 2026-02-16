package com.tripmate.auth_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MatchedTravellerDTO {

    private Long userId;
    private String userName;
}
