package com.example.authenticator.mapstruct;

import com.example.authenticator.model.UserModel;
import com.example.authenticator.repository.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User convertUserModelToUserEntity (UserModel userModel);

    List<User> convertUserModelListToUserEntityList (List<UserModel> userModels);

    List<UserModel> convertUserEntityListToUserModelList (List<User> users);

    UserModel convertUserEntityToUserModel (User user);
 }
