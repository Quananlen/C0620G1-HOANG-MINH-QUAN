package BO.customer;

import DAO.customer.CustomerTypeDAO;
import model.CustomerType;

import java.util.ArrayList;

public class CustomerTypeBO implements ICustomerTypeBO{
    CustomerTypeDAO customerTypeDAO = new CustomerTypeDAO();

    @Override
    public ArrayList<CustomerType> getAllCustomerType() {
        return customerTypeDAO.getAllCustomerType();
    }
}
