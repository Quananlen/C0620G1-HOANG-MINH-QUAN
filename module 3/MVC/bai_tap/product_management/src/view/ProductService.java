package view;

import model.Product;

import java.util.List;

public interface ProductService {
    void add(Product product);
    List<Product> getAll();
    void delete();
}
