package com.springsecurity.controller;

import com.springsecurity.model.User;
import com.springsecurity.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/createuser")
    @ApiOperation(value = "Creating a User",
            notes = "Provide a User request body for creating a User",
            response = User.class)
    public User createUser(@Valid @RequestBody User user) {
        log.info("Inside create user method in controller !!");
        return userRepository.save(user);
    }

    @GetMapping("/getallusers")
    @ApiOperation(value = "Find All Users",
            notes = "Getting a list of Users",
            response = User.class)
    public List<User> getAllUsers() {
        log.info("Inside get all user method in controller !!");
        return userRepository.findAll();
    }

}