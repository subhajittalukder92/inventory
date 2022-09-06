package com.example.testproject.service;

import com.example.testproject.dao.UserRepository;
import com.example.testproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> result= userRepository.findById(id);
        User user = null;
        if(result.isPresent()){
            user = result.get();
        }
        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByEmail(String email) {
       return userRepository.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
