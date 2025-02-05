package com.wycliffe.pointofsalesystem.service.impl;

import com.wycliffe.pointofsalesystem.dto.UserPwdDto;
import com.wycliffe.pointofsalesystem.entity.UserEntity;
import com.wycliffe.pointofsalesystem.repository.UserRepository;
import com.wycliffe.pointofsalesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Injecting PasswordEncoder

    @Override
    public UserEntity changeUserPassword(Long id, UserPwdDto userPwdDto) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity != null) {
            // Encode the new password
            String encodedPassword = passwordEncoder.encode(userPwdDto.getPassword());
            userEntity.setPassword(encodedPassword);
            return userRepository.save(userEntity);
        } else {
            return null;
        }
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        // Encode the password before saving
        String encodedPassword = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(encodedPassword);
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<UserEntity> getUserByUsername(String username) {
        // Use the existing findByUsernameIgnoreCase method in the repository
        return userRepository.findByUsername(username);
    }
}
