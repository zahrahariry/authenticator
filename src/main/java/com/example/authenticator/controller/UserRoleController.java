package com.example.authenticator.controller;

import com.example.authenticator.model.UserRoleModel;
import com.example.authenticator.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/user-role")
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @GetMapping(value = "/get-user-role-by-id/{id}")
    public ResponseEntity getUserRoleById (@PathVariable(name = "id") Long id) {
        return userRoleService.getUserRoleById(id);
    }

    @GetMapping(value = "/get-user-role-by-user-id/{userId}")
    public ResponseEntity getUserRoleByUserId (@PathVariable(name = "userId") Long userId) {
        return userRoleService.getUserRoleByUserId(userId);
    }

    @GetMapping(value = "/get-user-role-by-role-id/{roleId}")
    public ResponseEntity getUserRolesByRoleId (@PathVariable(name = "roleId") Long roleId) {
        return userRoleService.getUserRolesByRoleId(roleId);
    }

    @PostMapping(value = "/save-user-role/")
    public ResponseEntity saveUserRole (@RequestBody UserRoleModel userRoleModel) {
        return userRoleService.saveUserRole(userRoleModel);
    }

    @DeleteMapping(value = "/delete-user-role/{id}")
    public ResponseEntity deleteUserRole (@PathVariable(name = "id") Long id) {
        return userRoleService.deleteUserRole(id);
    }

    @PutMapping(value = "/update-user-role/{id}")
    public ResponseEntity updateUserRole (@PathVariable(name = "id") Long id, @RequestBody UserRoleModel userRoleModel) {
        return userRoleService.updateUserRole(id, userRoleModel);
    }


}
