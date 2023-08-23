package com.example.authenticator.repository;

import jakarta.persistence.*;

@Entity
@Table(name = "PERMISSION")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PERMISSION_NAME", unique = true)
    private String permissionName;

}
