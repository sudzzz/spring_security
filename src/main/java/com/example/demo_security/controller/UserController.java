package com.example.demo_security.controller;

import com.example.demo_security.entity.UserProfile;
import com.example.demo_security.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    UserProfileService userProfileService;


    @GetMapping("/test")
    public String test(){
        return "Service is up!";

    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String check(){
        return "Check for user role";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String admin(){
        return "Check for admin role";
    }

    @GetMapping("/uts_user")
    @PreAuthorize("hasAuthority('ROLE_UTS')")
    public String checkUts(){
        return "Check for uts_user role";
    }


    @PostMapping("/saveUserProfile")
    public UserProfile saveUserProfile(@RequestBody UserProfile userProfile){
        return userProfileService.saveUserProfile(userProfile);
    }


}
