package com.tripmate.auth_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Email
    @Column(name = "user_email", nullable = false, unique = true)
    private String userEmail;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "origin_country", nullable = false)
    private String origin_country;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;



}
