package com.example.authenticator.service;

import com.example.authenticator.exception.ObjectCurrentlyIsExistsException;
import com.example.authenticator.exception.ObjectNotFoundException;
import com.example.authenticator.mapstruct.RolePermissionMapper;
import com.example.authenticator.model.RolePermissionModel;
import com.example.authenticator.repository.RolePermission;
import com.example.authenticator.repository.RolePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolePermissionService {

    @Autowired
    RolePermissionRepository rolePermissionRepository;

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    public RolePermission  findRolePermissionByRolePermissionId(Long id) {
        Optional<RolePermission> rolePermissionOpt = rolePermissionRepository.findRolePermissionById(id);
        return rolePermissionOpt.orElse(null);
    }

    public RolePermission findRolePermissionByRoleIdAndPermissionId (Long roleId, Long permissionId){
        Optional<RolePermission> rolePermissionOpt = rolePermissionRepository.findRolePermissionByRoleIdAndPermissionId(roleId, permissionId);
        return rolePermissionOpt.orElse(null);
    }

    public ResponseEntity getRolePermissionByRolePermissionId (Long id){
        RolePermission rolePermission = findRolePermissionByRolePermissionId(id);
        if (rolePermission == null) {
            throw new ObjectNotFoundException();
        }else {
            return new ResponseEntity(rolePermissionMapper.convertRolePermissionEntityToRolePermissionModel(rolePermission), HttpStatus.OK);
        }
    }

    public ResponseEntity getRolePermissionsByRoleId (Long roleId) {
        List<RolePermission> rolePermissions = rolePermissionRepository.findRolePermissionsByRoleId(roleId);
        return new ResponseEntity(rolePermissionMapper.convertRolePermissionEntityListToRolePermissionModelList(rolePermissions), HttpStatus.OK);
    }

    public ResponseEntity getRolePermissionsByPermissionId (Long permissionId) {
        List<RolePermission> rolePermissions = rolePermissionRepository.findRolePermissionsByPermissionId(permissionId);
        return new ResponseEntity(rolePermissionMapper.convertRolePermissionEntityListToRolePermissionModelList(rolePermissions), HttpStatus.OK);
    }

    public void saveRolePermissionEntity (RolePermission rolePermission) {
        rolePermissionRepository.saveAndFlush(rolePermission);
    }

    public ResponseEntity saveRolePermission (RolePermissionModel rolePermissionModel) {
        Optional<RolePermission> rolePermissionOpt = rolePermissionRepository.findRolePermissionByRoleIdAndPermissionId(rolePermissionModel.getRoleId(), rolePermissionModel.getPermissionId());
        if (rolePermissionOpt.isPresent()) {
            throw new ObjectCurrentlyIsExistsException();
        }else {
            rolePermissionRepository.saveAndFlush(rolePermissionMapper.convertRolePermissionModelToRolePermissionEntity(rolePermissionModel));
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    public ResponseEntity deleteRolePermissionByRoleIdAndPermissionId (Long roleId, Long permissionId){
        Optional<RolePermission> rolePermissionOpt = rolePermissionRepository.findRolePermissionByRoleIdAndPermissionId(roleId, permissionId);
        if (rolePermissionOpt.isPresent()){
            rolePermissionRepository.deleteRolePermissionByRoleIdAndPermissionId(roleId, permissionId);
            return new ResponseEntity(HttpStatus.OK);
        }else {
            throw new ObjectNotFoundException();
        }
    }


}
