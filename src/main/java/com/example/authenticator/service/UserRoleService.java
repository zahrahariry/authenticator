package com.example.authenticator.service;

import com.example.authenticator.exception.ObjectCurrentlyIsExistsException;
import com.example.authenticator.exception.ObjectNotFoundException;
import com.example.authenticator.mapstruct.UserRoleMapper;
import com.example.authenticator.model.UserRoleModel;
import com.example.authenticator.repository.UserRole;
import com.example.authenticator.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    UserRoleMapper userRoleMapper;

    public UserRole findUserRoleById (Long id) {
        Optional<UserRole> userRoleOpt = userRoleRepository.findUserRoleById(id);
        return userRoleOpt.orElse(null);
    }

    public ResponseEntity getUserRoleById (Long id) {
        UserRole userRole = findUserRoleById(id);
        if (userRole == null) {
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(userRoleMapper.convertUserRoleEntityToUserRoleModel(userRole), HttpStatus.OK);
        }
    }

    public ResponseEntity getUserRoleByUserId (Long userId) {
        List<UserRole> userRoles = userRoleRepository.findUserRolesByUserId(userId);
        return new ResponseEntity(userRoleMapper.convertUserRoleEntityListToUserRoleModelList(userRoles), HttpStatus.OK);
    }

    public ResponseEntity getUserRolesByRoleId (Long roleId) {
        List<UserRole> userRoles = userRoleRepository.findUserRolesByRoleId(roleId);
        return new ResponseEntity(userRoleMapper.convertUserRoleEntityListToUserRoleModelList(userRoles), HttpStatus.OK);
    }

    public ResponseEntity saveUserRole (UserRoleModel userRoleModel) {
        Optional<UserRole> userRoleOpt = userRoleRepository.findUserRoleByUserIdAndRoleId(userRoleModel.getUserId(), userRoleModel.getRoleId());
        if (userRoleOpt.isPresent()) {
            throw new ObjectCurrentlyIsExistsException();
        }else {
            userRoleRepository.saveAndFlush(userRoleOpt.get());
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    public ResponseEntity deleteUserRole (Long id) {
        UserRole userRole = findUserRoleById(id);
        if (userRole == null) {
            throw new ObjectNotFoundException();
        }else {
            userRoleRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    public ResponseEntity updateUserRole (Long id, UserRoleModel userRoleModel) {
        UserRole userRole = findUserRoleById(id);
        if (userRole == null) {
            throw new ObjectNotFoundException();
        }else {
            return new ResponseEntity(userRoleRepository.saveAndFlush(userRoleMapper.convertUserRoleModelToUserRoleEntity(userRoleModel)), HttpStatus.OK);
        }
    }


}
