package com.example.authenticator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long>, JpaRepository<Permission, Long> {

    Optional<Permission> findPermissionById (Long id);

    Optional<Permission> findPermissionByPermissionName (String name);
}
