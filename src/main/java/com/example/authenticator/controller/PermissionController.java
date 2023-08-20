package com.example.authenticator.controller;

import com.example.authenticator.model.PermissionModel;
import com.example.authenticator.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PutMapping(value = "/permission/update/{id}")
    public ResponseEntity updatePermission (@PathVariable(name = "id") Long id, @RequestBody PermissionModel permissionModel) {
        return permissionService.updatePermission(id, permissionModel);
    }

    @PostMapping(value = "/permission/save")
    public ResponseEntity savePermission (@RequestBody PermissionModel inputPermissionModel) {
        return permissionService.savePermission(inputPermissionModel);
    }

    @GetMapping(value = "/permission/get-by-id/{id}")
    public ResponseEntity<PermissionModel> getPermissionById (@PathVariable(name = "id") Long id){
        return permissionService.getPermissionById(id);
    }

    @GetMapping(value = "/permission/get-by-name/{name}")
    public ResponseEntity<PermissionModel> getPermissionByName (@PathVariable(name = "name") String name) {
        return permissionService.getPermissionByName(name);
    }

    @DeleteMapping(value = "/permission/delete/{id}")
    public ResponseEntity deletePermission (@PathVariable(name = "id") Long id){
        return permissionService.deletePermission(id);
    }


}
