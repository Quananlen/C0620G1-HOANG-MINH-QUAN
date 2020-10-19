package com.giga.service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> display();
    void delete(String id);

    Product getProduct(String id);

    void update(String id, Product product);
}
