package com.example.authenticator.mapstruct;

import com.example.authenticator.model.UserRoleModel;
import com.example.authenticator.repository.UserRole;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    UserRole convertUserRoleModelToUserRoleEntity (UserRoleModel userRoleModel);

    List<UserRole> convertUserRoleModelListToUserRoleEntityList (List<UserRoleModel> userRoleModels);

    UserRoleModel convertUserRoleEntityToUserRoleModel (UserRole userRole);

    List<UserRoleModel> convertUserRoleEntityListToUserRoleModelList (List<UserRole> userRoles);
}
