package DAO.service;

import DAO.BaseDAO;
import model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServiceDAO {
    BaseDAO baseDAO = new BaseDAO();
    Connection connection = baseDAO.getConnection();

    public void add(Service service) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into service " +
                            "value (?,?,?,?,?,?,?,?,?)"
            );
            String[] list = {service.getId(), service.getName(), service.getArea(), service.getFloor(),
                    service.getMaxAmount(), service.getRentCost(), service.getServiceTypeId(), service.getRentTypeID(), service.getStatus()};
            for (int i = 0; i < list.length; i++) {
                preparedStatement.setString(i+1, list[i]);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
