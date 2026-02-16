package com.tripmate.connect_with_traveller.repository;

import com.tripmate.connect_with_traveller.entity.Connection;
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

    // 🔹 Prevent reverse duplicate (A→B OR B→A)
    @Query("""
        SELECT c FROM Connection c
        WHERE (c.senderUserId = :user1 AND c.receiverUserId = :user2)
           OR (c.senderUserId = :user2 AND c.receiverUserId = :user1)
    """)
    Optional<Connection> findExistingConnection(
            Long user1,
            Long user2
    );

    // 🔹 Get pending requests received
    List<Connection>
    findByReceiverUserIdAndAcceptStatus(
            Long receiverUserId,
            String acceptStatus
    );

    // 🔹 Get accepted connections of user
    List<Connection>
    findBySenderUserIdOrReceiverUserIdAndAcceptStatus(
            Long senderUserId,
            Long receiverUserId,
            String acceptStatus
    );
}
