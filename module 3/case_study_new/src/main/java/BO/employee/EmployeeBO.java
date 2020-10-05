package BO.employee;

import DAO.Employee.EmployeeDAO;
import model.Employee;

import java.util.ArrayList;

public class EmployeeBO {
    EmployeeDAO employeeDAO = new EmployeeDAO();

    public void add(Employee employee) {
        employeeDAO.add(employee);
    }

    public ArrayList<Employee> displayAll() {
        return employeeDAO.displayAll();
    }

    public void delete(String id) {
        employeeDAO.delete(id);
    }
}
