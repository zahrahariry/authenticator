package com.example.authenticator.service;

import com.example.authenticator.repository.RolePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionService {

    @Autowired
    private RolePermissionRepository rolePermissionRepository;
}
