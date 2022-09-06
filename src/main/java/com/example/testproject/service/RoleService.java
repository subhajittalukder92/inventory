package com.example.testproject.service;

import com.example.testproject.entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAll();
    public Role findById(int id);
    public void save(Role role);
    public void deleteById(int id);
}
