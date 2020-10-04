package DAO.customer;

import DAO.BaseDAO;
import model.Customer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAO implements ICustomerDAO {
    BaseDAO baseDAO = new BaseDAO();
    Connection connection = baseDAO.getConnection();

    @Override
    public ArrayList<Customer> displayAll() {
        ArrayList<Customer> customerList = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall("call displayAll()");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String customerType = resultSet.getString("ct.name");
                String name = resultSet.getString("c.name");
                String birthday = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_card_number");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Customer customer = new Customer(id, customerType, name, birthday, idCard, phone, email, address);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }

    @Override
    public void delete(String id) {
        try {
            CallableStatement callableStatement = connection.prepareCall("call deleteCustomer(?)");
            callableStatement.setString(1, id);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Customer customer) {
        try {
            CallableStatement callableStatement = connection.prepareCall("call addCustomer(?,?,?,?,?,?,?,?)");
            String[] list = {customer.getId(), customer.getCustomerType(), customer.getName(), customer.getBirthday(), customer.getIdCard(), customer.getPhone(), customer.getEmail(), customer.getAddress()};
            for (int i = 0; i < list.length; i++) {
                callableStatement.setString(i + 1, list[i]);
            }
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomer(String id) {
        Customer customer = null;
        try {
            CallableStatement callableStatement = connection.prepareCall("call getCustomer(?)");
            callableStatement.setString(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            resultSet.next();
            String newID = resultSet.getString("id");
            String customerType = resultSet.getString("customer_type_id");
            String name = resultSet.getString("name");
            String birthday = resultSet.getString("date_of_birth");
            String idCard = resultSet.getString("id_card_number");
            String phone = resultSet.getString("phone");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            customer = new Customer(newID, customerType, name, birthday, idCard, phone, email, address);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public void editCustomer(String id, Customer customer) {
        try {
            CallableStatement callableStatement = connection.prepareCall("call editCustomer(?,?,?,?,?,?,?,?,?)");
            String[] list = {id, customer.getId(), customer.getCustomerType(), customer.getName(), customer.getBirthday(), customer.getIdCard(), customer.getPhone(), customer.getEmail(), customer.getAddress()};
            for (int i = 0; i < list.length; i++) {
                callableStatement.setString(i + 1, list[i]);
            }
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
