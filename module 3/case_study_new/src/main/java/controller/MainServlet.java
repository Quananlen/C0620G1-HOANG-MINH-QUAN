package controller;

import BO.customer.CustomerBO;
import BO.customer.CustomerTypeBO;
import BO.customer.ICustomerBO;
import BO.customer.ICustomerTypeBO;
import common.PropertyBO;
import common.StringMod;
import model.Customer;
import model.CustomerType;

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
//        String[] propertyList = {"id", "name", "birthday", "idCard", "phone", "email", "address"};
//        String[] labelList = {"ID", "Name", "Birthday", "ID Card", "Phone", "Email", "Address"};
        String[] propertyList =  propertyBO.getProperty("customer");
        String[] labelList = StringMod.turnFieldToLabel(propertyBO.getProperty("customer"));
        request.setAttribute("length", propertyList.length);
        request.setAttribute("propertyList", propertyList);
        request.setAttribute("labelList", labelList);
        request.setAttribute("customerTypeList", customerTypeList);
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String customerType = request.getParameter("type");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String idCard = request.getParameter("idCard");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
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
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }

}
