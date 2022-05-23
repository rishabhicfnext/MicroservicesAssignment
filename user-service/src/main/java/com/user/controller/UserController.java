package com.user.controller;

import com.user.exception.UserAlreadyExistException;
import com.user.exception.UserNotFoundException;
import com.user.model.User;
import com.user.service.impl.UserServiceImpl;
import com.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/createuser")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        int isExist = userService.isUserExistByOfficeID(user.getOfficeID());
        if (isExist != 0) {
            throw new UserAlreadyExistException();
        } else {
            user = userService.createUser(user);
            return new ResponseEntity<Object>(user, HttpStatus.CREATED);
        }
    }

    @PutMapping("/updateuser/{userID}")
    public ResponseEntity<Object> updateUser(@PathVariable("userID") long userID, @Valid @RequestBody User user) {
        boolean isExist = userService.isUserExist(userID);
        if (isExist) {
            user.setUserID(userID);
            userService.updateUser(user);
            return new ResponseEntity<Object>("User Updated successfully : \n" + user, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

    @DeleteMapping("/deleteuser/{userID}")
    public ResponseEntity<Object> deleteUser(@PathVariable("userID") long userID) {
        boolean isExist = userService.isUserExist(userID);
        if (isExist) {
            User user = userService.getUser(userID);
            userService.deleteUser(userID);
            return new ResponseEntity<Object>(user, HttpStatus.GONE);
        } else {
            throw new UserNotFoundException();
        }
    }

    @GetMapping("/getuserbyid/{userID}")
    public ResponseEntity<Object> getUserById(@PathVariable("userID") long userID) {
        boolean isExist = userService.isUserExist(userID);
        if (isExist) {
            User user = userService.getUser(userID);
            return new ResponseEntity<Object>(user, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

    @GetMapping("/getallusers")
    public ResponseEntity<Object> getAllUsers() {
        List<User> userList = userService.getUsers();
        if (userList.isEmpty()) {
            throw new UserNotFoundException();
        } else {
            return new ResponseEntity<Object>(userList, HttpStatus.OK);
        }
    }

    @GetMapping("/getallusersbyprojectid/{projectID}")
    public ResponseEntity<Object> getAllUsersByProjectID(@PathVariable("projectID") long projectID) {
        List<User> userList = userService.getUsersByProjectID(projectID);
        if (userList.isEmpty()) {
            throw new UserNotFoundException();
        } else {
            return new ResponseEntity<Object>(userList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/getuserwithproject/{projectID}")
    public ResponseTemplateVO getUserWithProject(@PathVariable("projectID") long projectID) {
        log.info("Inside getUserWithProject of User Controller");
        return userService.getUserWithProject(projectID);
    }

}