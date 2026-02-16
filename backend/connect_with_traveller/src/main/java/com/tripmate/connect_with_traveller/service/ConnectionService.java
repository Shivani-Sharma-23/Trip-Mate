package com.tripmate.connect_with_traveller.service;

import com.tripmate.connect_with_traveller.entity.Connection;
import com.tripmate.connect_with_traveller.repository.ConnectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ConnectionService {

    private final ConnectionRepository repository;

    public Connection sendRequest(
            Long senderId,
            String originCountry,
            Long receiverId,
            String currTravelCountry) {

        Connection connection =
                Connection.builder()
                        .senderUserId(senderId)
                        .receiverUserId(receiverId)
                        .originCountry(originCountry)
                        .currTravelCountry(currTravelCountry)
                        .acceptStatus("PENDING")
                        .createdAt(LocalDateTime.now())
                        .build();

        return repository.save(connection);
    }
}

