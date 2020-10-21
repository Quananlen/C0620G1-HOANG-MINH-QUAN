package com.giga.service;


import com.giga.entity.Product;
import com.giga.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService  implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> display() {
        return productRepository.findAll();
    }

    @Override
    public void delete(String id) {
        productRepository.delete(getProduct(id));
    }

    @Override
    public Product getProduct(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }
}
