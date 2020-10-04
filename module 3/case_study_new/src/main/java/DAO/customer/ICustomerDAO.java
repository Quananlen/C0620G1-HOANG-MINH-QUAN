package DAO.customer;

import model.Customer;

import java.util.ArrayList;

public interface ICustomerDAO {
    ArrayList<Customer> displayAll();

    void delete(String id);

    void add(Customer customer);

    Customer getCustomer(String id);

    void editCustomer(String id, Customer customer);
}
