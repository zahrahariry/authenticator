package com.example.authenticator.mapstruct;

import com.example.authenticator.model.PermissionModel;
import com.example.authenticator.repository.Permission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionModel convertPermissionEntityToModel (Permission permission);

    Permission convertPermissionModelToEntity (PermissionModel permissionModel);

    List<Permission> convertPermissionModelListToEntityList (List<PermissionModel> permissionModels);

    List<PermissionModel> convertPermissionEntityListToModelList (List<Permission> permissions);

}
