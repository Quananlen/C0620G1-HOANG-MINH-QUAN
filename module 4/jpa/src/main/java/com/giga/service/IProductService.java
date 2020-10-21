package com.giga.service;
import com.giga.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> display();
    void delete(String id);

    Product getProduct(String id);

    void update(Product product);

    void create(Product product);
}
