package com.example.testproject.service;

import com.example.testproject.dao.ProductRepository;
import com.example.testproject.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        //return productRepository.findAll();
       return productRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Product findById(int id) {
        Optional<Product> result = productRepository.findById(id);
        Product product = null;
        if(result.isPresent()){
            product = result.get();
        }
        return product;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
