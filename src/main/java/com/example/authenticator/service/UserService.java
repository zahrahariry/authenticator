package com.example.authenticator.service;

import com.example.authenticator.mapstruct.UserMapper;
import com.example.authenticator.repository.User;
import com.example.authenticator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public User findUserBuUserId (Long id) {

    }

}
