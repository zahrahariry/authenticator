package com.example.authenticator.repository;

import jakarta.persistence.*;

@Entity
@Table(name = "USER_ROLE")
public class UserRole {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "ROLE_ID")
    private Long roleId;
}
