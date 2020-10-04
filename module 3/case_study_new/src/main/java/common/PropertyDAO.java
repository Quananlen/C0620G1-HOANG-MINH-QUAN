package common;

import DAO.BaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Stack;

public class PropertyDAO {
    BaseDAO baseDAO = new BaseDAO();
    Connection connection = baseDAO.getConnection();

    public String[] getProperty(String column) {
        Stack<String> propertyList = new Stack<>();
        String[] propertyStringList = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("show columns from " + column);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                propertyList.add(resultSet.getString("Field"));
            }
            propertyStringList = propertyList.toArray(new String[0]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propertyStringList;
    }
}
