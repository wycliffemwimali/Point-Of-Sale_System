package com.wycliffe.pointofsalesystem.controller;

import com.wycliffe.pointofsalesystem.dto.UserPwdDto;
import com.wycliffe.pointofsalesystem.entity.UserEntity;
import com.wycliffe.pointofsalesystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Api(tags = "User Management", description = "Operations related to user management")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @ApiOperation(value = "Get all users", notes = "Returns a list of all users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the list of users"),
            @ApiResponse(code = 204, message = "No users found")
    })
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(users); // 204 No Content
        }
        return ResponseEntity.status(HttpStatus.OK).body(users); // 200 OK
    }

    @PostMapping("/users")
    @ApiOperation(value = "Create a new user", notes = "Creates a new user with the provided details")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created a new user"),
            @ApiResponse(code = 400, message = "Invalid input data")
    })
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
        try {
            UserEntity createdUser = userService.createUser(userEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser); // 201 Created
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // 400 Bad Request
        }
    }

    @GetMapping("/users/{id}")
    @ApiOperation(value = "Get user by ID", notes = "Fetches a user by their ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved user details"),
            @ApiResponse(code = 404, message = "User not found")
    })
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        UserEntity user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user); // 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404 Not Found
        }
    }

    @PutMapping("/users/{id}/change-password")
    @ApiOperation(value = "Change user password", notes = "Allows user to change their password")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Password updated successfully"),
            @ApiResponse(code = 404, message = "User not found")
    })
    public ResponseEntity<String> changeUserPassword(@PathVariable Long id, @RequestBody UserPwdDto userPwdDto) {
        UserEntity updatedUser = userService.changeUserPassword(id, userPwdDto);
        if (updatedUser != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Password updated successfully"); // 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found"); // 404 Not Found
        }
    }
}
