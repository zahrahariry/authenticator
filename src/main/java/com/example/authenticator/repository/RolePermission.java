package com.example.authenticator.repository;


import jakarta.persistence.*;

@Entity
@Table(name = "ROLE_PERMISSION")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "PERMISSION_ID")
    private Long permissionId;

}
