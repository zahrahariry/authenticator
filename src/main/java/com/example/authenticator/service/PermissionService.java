package com.example.authenticator.service;

import com.example.authenticator.exception.ObjectCurrentlyIsExistsException;
import com.example.authenticator.exception.ObjectNotFoundException;
import com.example.authenticator.mapstruct.PermissionMapper;
import com.example.authenticator.model.PermissionModel;
import com.example.authenticator.repository.Permission;
import com.example.authenticator.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    PermissionMapper permissionMapper;

    public Permission findPermissionById (Long id){
        Optional<Permission> permissionOpt = permissionRepository.findPermissionById(id);
        return permissionOpt.orElse(null);
    }

    public Permission findPermissionByName (String name){
        Optional<Permission> permissionOpt = permissionRepository.findPermissionByPermissionName(name);
        return permissionOpt.orElse(null);
    }

    public void savePermissionEntity (PermissionModel permissionModel) {
        Permission permissionEntity = permissionMapper.convertPermissionModelToEntity(permissionModel);
        permissionRepository.saveAndFlush(permissionEntity);
    }

    public ResponseEntity updatePermission (Long id, PermissionModel permissionModel) {
        Permission permission = findPermissionById(id);
        if (permission != null){
            Permission permissionEntity = permissionMapper.convertPermissionModelToEntity(permissionModel);
            permissionRepository.saveAndFlush(permissionEntity);
            return new ResponseEntity(HttpStatus.OK);
        }else {
            throw new ObjectNotFoundException();
        }
    }

    public ResponseEntity savePermission (PermissionModel inputPermissionModel) {
        Permission permission = findPermissionByName(inputPermissionModel.getPermissionName());
        if (permission != null) {
            throw new ObjectCurrentlyIsExistsException();
        }else {
            savePermissionEntity(inputPermissionModel);
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    public ResponseEntity<PermissionModel> getPermissionById (Long id){
        Permission permissionEntity = findPermissionById(id);
        if (permissionEntity != null) {
            return new ResponseEntity<>(permissionMapper.convertPermissionEntityToModel(permissionEntity), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    public ResponseEntity<PermissionModel> getPermissionByName (String name) {
        Optional<Permission> permissionOpt = permissionRepository.findPermissionByPermissionName(name);
        return permissionOpt.map(permission -> new ResponseEntity<>(permissionMapper.convertPermissionEntityToModel(permission), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.OK));
    }

    public ResponseEntity deletePermission (Long id){
        Permission permissionEntity = findPermissionById(id);
        if (permissionEntity != null){
            permissionRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }else {
            throw new ObjectNotFoundException();
        }
    }


}
