package com.example.testproject.service;

import com.example.testproject.entity.Client;

import java.util.List;

public interface ClientService {
    public List<Client> findAll();
    public Client findById(int id);
    public void save(Client client);
    public void deleteById(int id);
}
