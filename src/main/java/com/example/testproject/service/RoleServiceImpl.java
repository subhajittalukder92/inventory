package com.example.testproject.service;

import com.example.testproject.dao.RoleRepository;
import com.example.testproject.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository ;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        Optional<Role> result = roleRepository.findById(id);
        Role role = null ;
        if(result.isPresent()){
            role= result.get();
        }
        return role ;
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }
}
