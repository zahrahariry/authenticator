package com.example.authenticator.service;

import com.example.authenticator.exception.ObjectNotFoundException;
import com.example.authenticator.mapstruct.PermissionMapper;
import com.example.authenticator.model.PermissionModel;
import com.example.authenticator.repository.Permission;
import com.example.authenticator.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void savePermissionEntity (PermissionModel permissionModel) {
        Permission permissionEntity = permissionMapper.convertPermissionModelToEntity(permissionModel);
        permissionRepository.saveAndFlush(permissionEntity);
    }

    public void updatePermission (Long id, PermissionModel permissionModel) {
        Permission permission = findPermissionById(id);
        if (permission != null){
            Permission permissionEntity = permissionMapper.convertPermissionModelToEntity(permissionModel);
            permissionRepository.saveAndFlush(permissionEntity);
        }else {
            throw new ObjectNotFoundException();
        }
    }

    public void savePermission (PermissionModel inputPermissionModel) {

        Permission permissionEntity = permissionMapper.convertPermissionModelToEntity(inputPermissionModel);
        permissionRepository.save(permissionEntity);
    }

    public PermissionModel getPermissionById (Long id){
        Permission permission = permissionRepository.findby(id);
        if (permission == null){
            throw new ObjectNotFoundException();
        }else {
            return permissionMapper.convertPermissionEntityToModel(permission);
        }
    }

    public Permission getPermissionByName (String name) {
        Permission permission = permissionRepository.
    }


}
