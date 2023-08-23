package com.example.authenticator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>, JpaRepository<User, Long> {

    Optional<User> findUserById (Long userId);

    List<User> findUsersByName (String name);

    Optional<User> findUserByUsername (String username);

    Optional<User> findUserByUsernameAndPassword (String username, String password);

    void deleteUserByUsername (String username);
}
