package controller;

import BO.customer.CustomerBO;
import BO.customer.CustomerTypeBO;
import BO.customer.ICustomerBO;
import BO.customer.ICustomerTypeBO;
import BO.employee.EmployeeBO;
import common.PropertyBO;
import common.Validate;
import model.Customer;
import model.CustomerType;
import model.Employee;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MainServlet", urlPatterns = {"","/CustomerServlet"})
public class MainServlet extends HttpServlet {
    ICustomerBO customerBO = new CustomerBO();
    ICustomerTypeBO customerTypeBO = new CustomerTypeBO();
    PropertyBO propertyBO = new PropertyBO();
    EmployeeBO employeeBO = new EmployeeBO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            default:
                displayCustomer(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                createCustomerForm(request, response);
                break;
            case "edit":
                editCustomerForm(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                displayCustomer(request, response);
        }
    }

    private void editCustomerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Customer customer = customerBO.getCustomer(id);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("edit.jsp").forward(request,response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String newID = request.getParameter("newId");
        String customerType = request.getParameter("type");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String idCard = request.getParameter("idCard");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(newID, customerType, name, birthday, idCard, phone, email, address);
        customerBO.editCustomer(id, customer);
        response.sendRedirect("/CustomerServlet");
    }

    private void createCustomerForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<CustomerType> customerTypeList = customerTypeBO.getAllCustomerType();
        String[] propertyList = {"id", "name", "birthday", "idCard", "phone", "email", "address"};
        String[] labelList = {"ID", "Name", "Birthday", "ID Card", "Phone", "Email", "Address"};
//        String[] propertyList =  propertyBO.getCustomerProperty();
//        String[] labelList = StringMod.turnFieldToLabel(propertyBO.getCustomerProperty());
        request.setAttribute("length", propertyList.length);
        request.setAttribute("propertyList", propertyList);
        request.setAttribute("labelList", labelList);
        request.setAttribute("customerTypeList", customerTypeList);
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<CustomerType> customerTypeList = customerTypeBO.getAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);

        String id = request.getParameter("id");
        String messageId = Validate.validateCustomerID(id);
        request.setAttribute("messageId", messageId);
        request.setAttribute("id", id);

        String customerType = request.getParameter("type");
        request.setAttribute("type", customerType);

        String name = request.getParameter("name");
        request.setAttribute("name", name);

        String birthday = request.getParameter("birthday");
        request.setAttribute("birthday", birthday);

        String idCard = request.getParameter("idCard");
        String messageIdCard = Validate.validateIdCard(idCard);
        request.setAttribute("idCard",idCard);
        request.setAttribute("messageIdCard",messageIdCard);

        String phone = request.getParameter("phone");
        String messagePhone = Validate.validatePhone(phone);
        request.setAttribute("messagePhone", messagePhone);
        request.setAttribute("phone", phone);

        String email = request.getParameter("email");
        String messageEmail = Validate.validateEmail(email);
        request.setAttribute("email", email);
        request.setAttribute("messageEmail", messageEmail);

        String address = request.getParameter("address");
        request.setAttribute("address", address);


        boolean isValidated = messageId.equals("OK") && messageIdCard.equals("OK") && messagePhone.equals("OK") && messageEmail.equals("OK");
        if (!isValidated) {
            request.getRequestDispatcher("create.jsp").forward(request, response);
        }

        customerBO.add(new Customer(id, customerType, name, birthday, idCard, phone, email, address));
        response.sendRedirect("/CustomerServlet");
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        customerBO.delete(id);
        response.sendRedirect("CustomerServlet");
    }

    private void displayCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerBO.displayAll();
        request.setAttribute("customerList", customerList);

        List<Employee> employeeList = employeeBO.displayAll();
        request.setAttribute("employeeList",employeeList);

        request.getRequestDispatcher("home.jsp").forward(request,response);
    }

}
