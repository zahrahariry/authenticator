package com.example.authenticator.controller;

import com.example.authenticator.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PermissionController {

    @Autowired
    private PermissionService permissionService;
}
