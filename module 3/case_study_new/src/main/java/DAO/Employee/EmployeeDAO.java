package DAO.Employee;

import DAO.BaseDAO;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {
    BaseDAO baseDAO = new BaseDAO();
    Connection connection = baseDAO.getConnection();

    public void add(Employee employee) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into employee " +
                            "value (?,?,?,?,?,?,?,?,?,?,?)"
            );
            String[] list = {employee.getId(), employee.getName(),employee.getPositionId(),employee.getEducationId(), employee.getDepartmentId(),
                    employee.getBirthday(), employee.getIdCard(), employee.getSalary(), employee.getPhone(), employee.getEmail(), employee.getAddress()};
            for (int i = 0; i < list.length; i++) {
                preparedStatement.setString(i+1, list[i]);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Employee> displayAll() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * \n" +
                            "from employee e " +
                            "join position p on e.position_id = p.id " +
                            "join education edu on e.education_id = edu.id " +
                            "join department d on e.department_id = d.id "
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String positionId = resultSet.getString("position_name");
                String educationId = resultSet.getString("education_name");
                String departmentId = resultSet.getString("department_name");
                String birthday = resultSet.getString("date_of_birth");
                String idCardNumber = resultSet.getString("id_card_number");
                String salary = resultSet.getString("salary");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                employeeList.add(new Employee(id, name, positionId, educationId, departmentId, birthday, idCardNumber, salary, phone, email, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public void delete(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from employee where id = ?"
            );
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
