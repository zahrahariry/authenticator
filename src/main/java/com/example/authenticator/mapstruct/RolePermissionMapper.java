package com.example.authenticator.mapstruct;

import com.example.authenticator.model.RolePermissionModel;
import com.example.authenticator.repository.RolePermission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolePermissionMapper {

    RolePermission convertRolePermissionModelToRolePermissionEntity (RolePermissionModel rolePermissionModel);

    List<RolePermission> convertRolePermissionModelListToRolePermissionEntityList (List<RolePermissionModel> rolePermissionModels);

    RolePermissionModel convertRolePermissionEntityToRolePermissionModel (RolePermission rolePermission);

    List<RolePermissionModel> convertRolePermissionEntityListToRolePermissionModelList (List<RolePermission> rolePermissions);
}
