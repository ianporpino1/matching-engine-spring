package com.matchingengine.controller;

import com.matchingengine.controller.dto.UserRequest;
import com.matchingengine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
    }
    
//    @GetMapping
//    public ResponseEntity<List<UserResponse>> getAllUsers() {
//        List<UserR> users = userService.getAllUsers();
//        return ResponseEntity.ok(userService.getAllUsers());
//    }
    
    
    
    
}
