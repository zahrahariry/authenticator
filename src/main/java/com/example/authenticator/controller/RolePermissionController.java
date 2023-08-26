package com.example.authenticator.controller;
import com.example.authenticator.model.RolePermissionModel;
import com.example.authenticator.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/role-permission")
public class RolePermissionController {

    @Autowired
    RolePermissionService rolePermissionService;

    @GetMapping(value = "/role-permission-by-id/{id]")
    public ResponseEntity getRolePermissionByRolePermissionId (@PathVariable(name = "id") Long id){
        return rolePermissionService.getRolePermissionByRolePermissionId(id);
    }

    @GetMapping(value = "/role-permission-by-role-id/{roleId}")
    public ResponseEntity getRolePermissionsByRoleId (@PathVariable(name = "roleId") Long roleId) {
        return rolePermissionService.getRolePermissionsByRoleId(roleId);
    }

    @GetMapping(value = "/role-permission-by-permission-id/{permissionId}")
    public ResponseEntity getRolePermissionsByPermissionId (@PathVariable(name = "permissionId") Long permissionId) {
        return rolePermissionService.getRolePermissionsByPermissionId(permissionId);
    }
    @PostMapping(value = "/save-role-permission/")
    public ResponseEntity saveRolePermission (@RequestBody RolePermissionModel rolePermissionModel) {
        return rolePermissionService.saveRolePermission(rolePermissionModel);
    }

    @DeleteMapping(value = "/delete-role-permission/{roleId}/{permissionId}")
    public ResponseEntity deleteRolePermissionByRoleIdAndPermissionId (@PathVariable(name = "roleId") Long roleId, @PathVariable(name = "permissionId") Long permissionId){
        return rolePermissionService.deleteRolePermissionByRoleIdAndPermissionId(roleId, permissionId);
    }

    @DeleteMapping(value = "/delete-role-permission-by-id/{id}")
    public ResponseEntity deleteRolePermissionByRolePermissionId (@PathVariable(name = "id") Long id) {
        return rolePermissionService.deleteRolePermissionById(id);
    }

}
