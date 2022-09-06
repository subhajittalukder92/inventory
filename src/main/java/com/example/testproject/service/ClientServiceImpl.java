package com.example.testproject.service;

import com.example.testproject.dao.ClientRepository;
import com.example.testproject.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(int id) {
        return null;
    }

    @Override
    public void save(Client client) {

    }

    @Override
    public void deleteById(int id) {

    }
}
