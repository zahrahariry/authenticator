package com.example.authenticator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRoleRepository extends CrudRepository<UserRole, Long>, JpaRepository<UserRole, Long> {

    Optional<UserRole> findUserRoleById (Long id);

    List<UserRole> findUserRolesByUserId (Long userRoleId);

    List<UserRole> findUserRolesByRoleId (Long roleId);

    Optional<UserRole> findUserRoleByUserIdAndRoleId (Long userId, Long roleId);
}
