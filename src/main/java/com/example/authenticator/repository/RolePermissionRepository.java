package com.example.authenticator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionRepository extends CrudRepository<RolePermission, Long>, JpaRepository<RolePermission, Long> {
}
