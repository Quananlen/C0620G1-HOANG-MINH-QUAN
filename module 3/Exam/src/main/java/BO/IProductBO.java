package BO;

import model.Product;

import java.util.ArrayList;

public interface IProductBO {
    ArrayList<Product> displayAll();
    void delete(String name);
    Product getProduct(String name);
    void create(Product product);
    Product getProductPrice(String price);
}
