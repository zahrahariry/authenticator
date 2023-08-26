package com.example.authenticator.controller;

import com.example.authenticator.model.UserModel;
import com.example.authenticator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/get-user-by-id/{id}")
    public ResponseEntity getUserByUserId (@PathVariable(name = "id") Long id) {
        return userService.getUserByUserId(id);
    }

    public ResponseEntity getUserByUsername (String username) {

    }

    public ResponseEntity getUserByUsernameAndPassword (String username, String password) {

    }

    public ResponseEntity saveUser (UserModel userModel) {

    }

    public ResponseEntity deleteUser (String username) {

    }

    public ResponseEntity updateUser (Long id, UserModel userModel) {

    }
}
