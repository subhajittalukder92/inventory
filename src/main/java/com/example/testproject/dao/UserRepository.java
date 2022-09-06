package com.example.testproject.dao;

import com.example.testproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public boolean existsByEmail(String email);
    public User findByEmail(String email);
}
