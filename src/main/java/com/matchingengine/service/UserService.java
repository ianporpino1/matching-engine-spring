package com.matchingengine.service;

import com.matchingengine.controller.dto.UserRequest;
import com.matchingengine.model.User;
import com.matchingengine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    public void createUser(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.username());
        
        user.setPassword(passwordEncoder.encode(userRequest.password()));
        userRepository.save(user);
    }
    
   
    
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username).orElseThrow(RuntimeException::new);
    }
}
