package com.example.authenticator.controller;

import com.example.authenticator.model.RoleModel;
import com.example.authenticator.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/role")
@CrossOrigin
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping(value = "/get-role-by-id/{id}")
    public ResponseEntity<RoleModel> getRoleById (@PathVariable(name = "id") Long id){
        return roleService.getRoleById(id);
    }

    @GetMapping(value = "/get-role-by-name/{name}")
    public ResponseEntity<RoleModel> getRoleByName (@PathVariable(name = "name") String name) {
        return roleService.getRoleByName(name);
    }

    @PostMapping(value = "/save-role")
    public ResponseEntity saveRole (@RequestBody RoleModel roleModel) {
        return saveRole(roleModel);
    }

    @PutMapping(value = "/update-role/{id}")
    public ResponseEntity updateRole (@PathVariable(name = "id") Long id, @RequestBody RoleModel roleModel){
        return roleService.updateRole(id, roleModel);
    }

    @DeleteMapping(value = "/delete-role-by-id/{id}")
    public ResponseEntity deleteRole (@PathVariable(name = "id") Long id){
        return roleService.deleteRole(id);
    }
}
