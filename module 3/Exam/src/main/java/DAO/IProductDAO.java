package DAO;

import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IProductDAO {
    ArrayList<Product> displayAll();

    void delete(String name);

    Product getProduct(String name);

    void create(Product product);

    void edit(String id, Product product);

    Product getProductPrice(String price);
}
