package controller;

import BO.employee.EmployeeBO;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    EmployeeBO employeeBO = new EmployeeBO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            default:
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                createEmployeeForm(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
            default:
                displayEmployee(request, response);
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        employeeBO.delete(id);
    }

    private void createEmployeeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("createEmployee.jsp").forward(request, response);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String positionId = request.getParameter("positionId");
        String educationId = request.getParameter("educationId");
        String departmentId = request.getParameter("departmentId");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        String salary = request.getParameter("salary");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Employee employee = new Employee(id, name, positionId, educationId, departmentId, birthday, idCard, salary, phone, email, address);
        employeeBO.add(employee);
        response.sendRedirect("/CustomerServlet");
    }

    private void displayEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeBO.displayAll();
        request.setAttribute("employeeList",employeeList);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
