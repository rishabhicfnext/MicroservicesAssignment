package com.user.service;

import com.user.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    void updateUser(User user);

    void deleteUser(long userID);

    User getUser(long userID);

    List<User> getUsers();

    boolean isUserExist(long userID);

    int isUserExistByOfficeID(String username);

}