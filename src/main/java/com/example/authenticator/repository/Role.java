package com.example.authenticator.repository;

import jakarta.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ROLE_NAME")
    private String roleName;
}
