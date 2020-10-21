package com.giga.service;


import com.giga.entity.Product;
import com.giga.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService  implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> display() {
        return productRepository.display();
    }

    @Override
    public void delete(String id) {
        productRepository.delete(id);
    }

    @Override
    public Product getProduct(String id) {
        return productRepository.getProduct(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }
}
