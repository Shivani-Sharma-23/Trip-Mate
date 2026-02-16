package com.tripmate.auth_service.service;

import com.tripmate.auth_service.dto.MatchedTravellerDTO;
import com.tripmate.auth_service.entity.Connection;
import com.tripmate.auth_service.repository.ConnectionRepository;
import com.tripmate.auth_service.repository.ConnectionRepository;
import com.tripmate.auth_service.repository.TravelPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConnectionService {

    private final ConnectionRepository connectionRepository;

    public List<MatchedTravellerDTO> findMatches(
            Long currentUserId,
            String origin,
            String destination) {

        return connectionRepository.findMatchingTravellers(
                origin,
                destination,
                currentUserId
        );
    }
}
