package com.user.controller;

import com.user.exception.UserNotFoundException;
import com.user.model.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createuser")
    public ResponseEntity<Object> createUser(@RequestBody User user)
    {
        user=userService.createUser(user);
        return new ResponseEntity<Object>("User is created successfully "+user.toString(),HttpStatus.CREATED);
    }

    @PutMapping("/updateuser/{userID}")
    public ResponseEntity<Object> updateUser(@PathVariable("userID") long userID, @RequestBody User user)
    {
        boolean isExist=userService.isUserExist(userID);
        if(isExist)
        {
            user.setUserID(userID);
            userService.updateUser(user);
            return new ResponseEntity<Object>("User is updated successfully "+user.toString(),HttpStatus.OK);
        }
        else
        {
            throw new UserNotFoundException();
        }
    }

    @DeleteMapping("/deleteuser/{userID}")
    public ResponseEntity<Object> deleteUser(@PathVariable("userID") long userID) throws Exception
    {
        boolean isExist=userService.isUserExist(userID);
        if(isExist)
        {
            userService.deleteUser(userID);
            return new ResponseEntity<Object>("User Deleted successfully with ID : "+userID,HttpStatus.GONE);
        }
        else
        {
            throw new UserNotFoundException();
        }
    }

    @GetMapping("/getuserbyid/{userID}")
    public ResponseEntity<Object> getUserById(@PathVariable("userID") long userID)
    {
        boolean isExist=userService.isUserExist(userID);
        if(isExist)
        {
            User user=userService.getUser(userID);
            return new ResponseEntity<Object>("User : "+user.toString(), HttpStatus.OK);
        }
        else
        {
            throw new UserNotFoundException();
        }
    }

    @GetMapping("/getallusers")
    public ResponseEntity<Object> getAllUsers()
    {
        List<User> userList=userService.getUsers();
        return new ResponseEntity<Object>(userList.toString(),HttpStatus.OK);
    }

}
