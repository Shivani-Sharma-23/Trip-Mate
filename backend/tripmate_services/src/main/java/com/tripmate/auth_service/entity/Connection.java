package com.tripmate.auth_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "connection",
        uniqueConstraints = {
                @UniqueConstraint(columnNames =
                        {"sender_user_id", "receiver_user_id"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sender_user_id", nullable = false)
    private Long senderUserId;

    @Column(name = "receiver_user_id", nullable = false)
    private Long receiverUserId;

    @Column(name = "curr_travel_country")
    private String currTravelCountry;

    @Column(name = "origin_country")
    private String originCountry;

    @Column(name = "accept_status", nullable = false)
    private String acceptStatus;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
