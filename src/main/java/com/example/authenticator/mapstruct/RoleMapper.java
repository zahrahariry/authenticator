package com.example.authenticator.mapstruct;

import com.example.authenticator.model.RoleModel;
import com.example.authenticator.repository.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleModel convertRoleEntityToRoleModel (Role role);

    Role convertRoleModelToRoleEntity (RoleModel roleModel);

    List<RoleModel> convertRoleEntityListToRoleModelList (List<Role> Roles);

    List<Role> convertRoleModelListToRoleEntityList (List<RoleModel> roleModels);
}
