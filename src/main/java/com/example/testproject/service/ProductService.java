package com.example.testproject.service;

import com.example.testproject.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product findById(int id);
    public void save(Product product);
    public void deleteById(int id);
}
