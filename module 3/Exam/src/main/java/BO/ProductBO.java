package BO;

import DAO.ProductDAO;
import model.Product;

import java.util.ArrayList;

public class ProductBO implements IProductBO{
    ProductDAO productDAO = new ProductDAO();

    @Override
    public ArrayList<Product> displayAll() {
        return productDAO.displayAll();
    }

    @Override
    public void delete(String name) {
        productDAO.delete(name);
    }

    @Override
    public Product getProduct(String name) {
        return productDAO.getProduct(name);
    }

    @Override
    public void create(Product product) {
        productDAO.create(product);
    }

    public void edit(String id, Product product) {
        productDAO.edit(id, product);
    }

    @Override
    public Product getProductPrice(String price) {
        return productDAO.getProductPrice(price);
    }
}
