package com.example.Sun_Base_Customer_Application.repository;

import com.example.Sun_Base_Customer_Application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
