package com.gateway.service;

import com.gateway.model.Login;
import com.gateway.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Login login = loginRepository.getUserByUserName(username);

        if (login == null) {
            throw new UsernameNotFoundException("User Not Found !!");
        }

        CustomUserDetails customUserDetails = new CustomUserDetails(login);
        return customUserDetails;
    }
}