package com.wycliffe.pointofsalesystem.service;

import com.wycliffe.pointofsalesystem.dto.UserPwdDto;
import com.wycliffe.pointofsalesystem.entity.UserEntity;
import java.util.List;
import java.util.Optional;

public interface UserService {
    UserEntity createUser(UserEntity userEntity);
    UserEntity getUserById(Long id);
    List<UserEntity> getAllUsers();
    UserEntity changeUserPassword(Long id, UserPwdDto userPwdDto);
    Optional<UserEntity> getUserByUsername(String username);  // Change return type to Optional
}
