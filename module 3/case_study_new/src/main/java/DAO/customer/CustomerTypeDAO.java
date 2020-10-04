package DAO.customer;

import DAO.BaseDAO;
import model.CustomerType;

import java.sql.*;
import java.util.ArrayList;

public class CustomerTypeDAO implements ICustomerTypeDAO {
    BaseDAO baseDAO = new BaseDAO();
    Connection connection = baseDAO.getConnection();

    @Override
    public ArrayList<CustomerType> getAllCustomerType() {
        ArrayList<CustomerType> customerTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from customer_type"
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                customerTypeList.add(new CustomerType(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerTypeList;
    }
}
