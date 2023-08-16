package com.example.authenticator.controller;

import com.example.authenticator.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;
}
