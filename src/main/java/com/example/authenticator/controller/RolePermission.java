package com.example.authenticator.controller;

import com.example.authenticator.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolePermission {

    @Autowired
    private RolePermissionService rolePermissionService;

}
