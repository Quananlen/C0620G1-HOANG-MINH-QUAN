package com.giga.repository;

import com.giga.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> display();
    void delete(String id);

    Product getProduct(String id);

    void update(Product product);

    void create(Product product);
}
