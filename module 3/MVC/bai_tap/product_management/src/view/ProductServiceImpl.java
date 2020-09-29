package view;

import controller.ProductServlet;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    public static List<Product> listProduct = new ArrayList<>();

    static {
        listProduct.add(new Product("1","McLaren","Mercedes","200"));
        listProduct.add(new Product("2","Gallardo","Lamborghini","260"));
        listProduct.add(new Product("3","DB10","Aston Martin","3500"));
        listProduct.add(new Product("4","488 Spider","Ferrari","360"));
        listProduct.add(new Product("5","Ghost","Rolls Royce","350"));
    }

    @Override
    public void add(Product product) {
        listProduct.add(product);
    }

    @Override
    public List<Product> getAll() {
        return listProduct;
    }

    @Override
    public void delete() {

    }
}
