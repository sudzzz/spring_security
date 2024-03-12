package com.example.demo_security.service;

import com.example.demo_security.config.UserInfoUserDetails;
import com.example.demo_security.entity.UserProfile;
import com.example.demo_security.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
public class UserInfoDetailService implements UserDetailsService {

    @Autowired
    UserProfileRepository userProfileRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile userProfile = userProfileRepository.findByUsername(username);
        if(Objects.nonNull(userProfile)){
            return new UserInfoUserDetails(userProfile);
        } else {
            throw new UsernameNotFoundException("User not found "+username);
        }

    }
}
