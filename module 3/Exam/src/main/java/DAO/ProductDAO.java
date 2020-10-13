package DAO;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO implements IProductDAO {
    BaseDAO baseDAO = new BaseDAO();
    Connection connection = baseDAO.getConnection();

    @Override
    public ArrayList<Product> displayAll() {
        ArrayList<Product> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from product"
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String quantity = resultSet.getString("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");
                list.add(new Product(name, price, quantity, color, description, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void delete(String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from product where `name` = ?"
            );
            preparedStatement.setString(1,name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getProduct(String name) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from product where name like concat('%',?,'%');"
            );
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String newName = resultSet.getString("name");
                String price = resultSet.getString("price");
                String quantity = resultSet.getString("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");
                product = new Product(newName, price, quantity, color, description, category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void create(Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into product value(?,?,?,?,?,?)"
            );
//            preparedStatement.setString(1, product.getId());
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setString(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(String id, Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update customer " +
                            "set id = ?, name = ? " +
                            "where id = ?"
            );
//            preparedStatement.setString(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getProductPrice(String price) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from product where price = ?"
            );
            preparedStatement.setString(1,price);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String quantity = resultSet.getString("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");
                product = new Product(name, price, quantity, color, description, category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
