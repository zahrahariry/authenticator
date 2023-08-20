package com.example.authenticator.service;

import com.example.authenticator.exception.ObjectCurrentlyIsExistsException;
import com.example.authenticator.mapstruct.RoleMapper;
import com.example.authenticator.model.RoleModel;
import com.example.authenticator.repository.Role;
import com.example.authenticator.repository.RoleRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleMapper roleMapper;

    public Role findRoleById (Long id){
        Optional<Role> roleOpt = roleRepository.findRoleById(id);
        return roleOpt.orElse(null);
    }

    public void saveRoleEntity (Role roleEntity){
        roleRepository.saveAndFlush(roleEntity);
    }

    public ResponseEntity<RoleModel> getRoleById (Long id){
        Role role = findRoleById(id);
        if (role == null){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(roleMapper.convertRoleEntityToRoleModel(role), HttpStatus.OK);
        }
    }

    public ResponseEntity<RoleModel> getRoleByName (String name) {
        Optional<Role> roleOpt = roleRepository.findRoleByRoleName(name);
        return roleOpt.map(role -> new ResponseEntity<>(roleMapper.convertRoleEntityToRoleModel(role), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.OK));
    }

    public ResponseEntity saveRole (RoleModel roleModel) {
        Optional<Role> roleOpt = roleRepository.findRoleByRoleName(roleModel.getRoleName());
        if (roleOpt.isPresent()){
            throw new ObjectCurrentlyIsExistsException();
        }else {
            roleRepository.saveAndFlush(roleMapper.convertRoleModelToRoleEntity(roleModel));
            return new ResponseEntity(HttpStatus.OK);
        }
    }

//    public ResponseEntity updateRole (Long id, RoleModel roleModel){
//        findRoleById(id);
//    }


}
