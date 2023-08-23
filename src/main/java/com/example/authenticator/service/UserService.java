package com.example.authenticator.service;

import com.example.authenticator.exception.ObjectCurrentlyIsExistsException;
import com.example.authenticator.exception.ObjectNotFoundException;
import com.example.authenticator.mapstruct.UserMapper;
import com.example.authenticator.model.UserModel;
import com.example.authenticator.repository.User;
import com.example.authenticator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public User findUserByUserId (Long id) {
        Optional<User> userOpt = userRepository.findUserById(id);
        return userOpt.orElse(null);
    }

    public User findUserByUsername (String username) {
        Optional<User> userOpt = userRepository.findUserByUsername(username);
        if (userOpt.isPresent()) {
            return userOpt.get();
        }else {
            return null;
        }
    }

    public ResponseEntity getUserByUserId (Long id) {
        User user = findUserByUserId(id);
        if (user == null) {
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(userMapper.convertUserEntityToUserModel(user), HttpStatus.OK);

        }
    }

    public ResponseEntity getUserByUsername (String username) {
        User user = findUserByUsername (username);
        if (user != null) {
            return new ResponseEntity(userMapper.convertUserEntityToUserModel(user), HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    public ResponseEntity getUserByUsernameAndPassword (String username, String password) {
        Optional<User> userOpt = userRepository.findUserByUsernameAndPassword(username, password);
        if (userOpt.isPresent()) {
            return new ResponseEntity(userMapper.convertUserEntityToUserModel(userOpt.get()), HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    public ResponseEntity saveUser (UserModel userModel) {
        Optional<User> userOpt = userRepository.findUserByUsername(userModel.getUsername());
        if (userOpt.isPresent()) {
            throw new ObjectCurrentlyIsExistsException();
        }else {
            userRepository.saveAndFlush(userMapper.convertUserModelToUserEntity(userModel));
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    public ResponseEntity deleteUser (String username) {
        User user = findUserByUsername(username);
        if (user == null) {
            throw new ObjectNotFoundException();
        }else {
            userRepository.deleteUserByUsername(username);
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    public ResponseEntity updateUser (Long id, UserModel userModel) {
        User user = findUserByUserId(id);
        if (user==null) {
            throw new ObjectNotFoundException();
        }else {
            userRepository.saveAndFlush(userMapper.convertUserModelToUserEntity(userModel));
            return new ResponseEntity(HttpStatus.OK);
        }
    }

}
