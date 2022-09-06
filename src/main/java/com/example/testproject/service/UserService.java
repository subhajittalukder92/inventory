package com.example.testproject.service;

import com.example.testproject.entity.User;

import java.util.List;

public interface UserService {
  public List<User> findAll();
  public User findById(int id);
  public void save(User user);
  public void deleteById(int id);
  public boolean existsByEmail(String email);
  public User findByEmail(String email);

}
