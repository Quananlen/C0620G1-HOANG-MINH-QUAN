package BO.customer;

import DAO.customer.CustomerDAO;
import model.Customer;

import java.util.ArrayList;

public class CustomerBO implements ICustomerBO {
    CustomerDAO customerDAO = new CustomerDAO();

    @Override
    public ArrayList<Customer> displayAll() {
        return customerDAO.displayAll();
    }

    @Override
    public void delete(String id) {
        customerDAO.delete(id);
    }

    @Override
    public void add(Customer customer) {
        customerDAO.add(customer);
    }

    @Override
    public Customer getCustomer(String id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    public void editCustomer(String id, Customer customer) {
        customerDAO.editCustomer(id, customer);
    }
}
