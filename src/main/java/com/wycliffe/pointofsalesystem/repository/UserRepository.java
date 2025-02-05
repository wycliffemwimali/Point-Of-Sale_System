package com.wycliffe.pointofsalesystem.repository;

import com.wycliffe.pointofsalesystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    Optional<UserEntity> findByUsername(String username);

//    Optional<UserEntity> findByUsernameIgnoreCase(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}