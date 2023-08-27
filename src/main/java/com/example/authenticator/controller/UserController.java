package com.example.authenticator.controller;

import com.example.authenticator.model.UserModel;
import com.example.authenticator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/get-user-by-id/{id}")
    public ResponseEntity getUserByUserId (@PathVariable(name = "id") Long id) {
        return userService.getUserByUserId(id);
    }

    @GetMapping(value = "/get-user-by-username/{username}")
    public ResponseEntity getUserByUsername (@PathVariable(name = "username") String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping(value = "/get-user-bu-username-and-password/{username}/{password}")
    public ResponseEntity getUserByUsernameAndPassword (@PathVariable(name = "username") String username, @PathVariable(name = "password") String password) {
        return userService.getUserByUsernameAndPassword(username, password);
    }

    @PostMapping(value = "/save-user")
    public ResponseEntity saveUser (@RequestBody UserModel userModel) {
        return userService.saveUser(userModel);
    }


    @DeleteMapping(value = "/delete-user/{username}")
    public ResponseEntity deleteUser (@PathVariable(name = "username") String username) {
        return userService.deleteUser(username);
    }

    @PutMapping(value = "/update-user/{id}")
    public ResponseEntity updateUser (@PathVariable(name = "id") Long id, @RequestBody UserModel userModel) {
        return userService.updateUser(id, userModel);
    }
}
