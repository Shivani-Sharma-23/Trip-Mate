package com.tripmate.auth_service.repository;

import com.tripmate.auth_service.dto.MatchedTravellerDTO;
import com.tripmate.auth_service.entity.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConnectionRepository
        extends JpaRepository<Connection, Long> {

    // 🔹 Check duplicate in same direction
    Optional<Connection>
    findBySenderUserIdAndReceiverUserId(
            Long senderUserId,
            Long receiverUserId
    );

    @Query("""
    SELECT new com.tripmate.auth_service.dto.MatchedTravellerDTO(
        u.id,
        u.name
    )
    FROM TravelPlan t
    JOIN User u ON t.userId = u.id
    WHERE t.originCountry = :origin
      AND t.destination = :destination
      AND t.travelStatus = 'ACTIVE'
      AND t.userId <> :currentUserId
""")
    List<MatchedTravellerDTO> findMatchingTravellers(
                    String origin,
                    String destination,
                    Long currentUserId
            );
}
