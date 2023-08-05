package com.example.authenticator.service;

import com.example.authenticator.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;
}
