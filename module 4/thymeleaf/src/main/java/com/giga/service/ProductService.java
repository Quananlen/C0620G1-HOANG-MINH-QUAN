package com.giga.service;

import model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService  implements IProductService {
    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("1", "iPhone 12", "600", 1));
        productList.add(new Product("2", "MacBook Air", "1200", 2));
        productList.add(new Product("3", "iWatch", "250", 3));
    }

    @Override
    public List<Product> display() {
        return productList;
    }

    @Override
    public void delete(String id) {
        productList.removeIf(product -> product.getId().equals(id));
    }

    @Override
    public Product getProduct(String id) {
        for (Product product: productList) {
            if (product.getId().equals(id)) return product;
        }
        return new Product();
    }

    @Override
    public void update(String id, Product product) {
        for (Product item: productList) {
            if (item.getId().equals(id)) {
                item.setId(product.getId());
                item.setName(product.getName());
                item.setPrice(product.getPrice());
                item.setCategory(product.getCategory());
                break;
            }
        }
    }
}
