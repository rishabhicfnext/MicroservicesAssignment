package com.user.service.impl;

import com.user.model.User;
import com.user.repository.UserRepository;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user)
    {
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void updateUser(User user)
    {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(long userID)
    {
        userRepository.deleteById(userID);
    }

    @Override
    public User getUser(long userID)
    {
        Optional<User> op=userRepository.findById(userID);
        User e=op.get();
        return e;
    }

    @Override
    public List<User> getUsers()
    {
        List<User> allUsers=userRepository.findAll();
        //System.out.println("Getting data : "+allUsers);
        return allUsers;
    }

    @Override
    public boolean isUserExist(long userID)
    {
        return userRepository.existsById(userID);
    }
}
