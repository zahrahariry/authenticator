package com.example.authenticator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolePermissionRepository extends CrudRepository<RolePermission, Long>, JpaRepository<RolePermission, Long> {

    Optional<RolePermission> findRolePermissionById (Long id);

    List<RolePermission> findRolePermissionsByRoleId (Long roleId);

    List<RolePermission> findRolePermissionsByPermissionId (Long per);
}
