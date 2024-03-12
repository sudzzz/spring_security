package com.example.demo_security.repository;

import com.example.demo_security.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Integer> {
    UserProfile findByUsername(String username);
}
