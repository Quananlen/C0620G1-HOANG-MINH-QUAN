package controller;

import BO.ProductBO;
import common.Validate;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MainServlet", urlPatterns = {"", "/MainServlet"})
public class MainServlet extends HttpServlet {
    ProductBO productBO = new ProductBO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                createForm(request, response);
                break;
            case "display":
                displayProduct(request, response);
                break;
            case "edit":
                editForm(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "findName":
                getProductName(request, response);
                break;
            case "findPrice":
                getProductPrice(request, response);
                break;
            default:
                response.sendRedirect("index.jsp");

        }
    }

    private void getProductPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String price = request.getParameter("findPrice");
        Product product = productBO.getProductPrice(price);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("display.jsp").forward(request,response);
    }

    private void getProductName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("findName");
        Product product = productBO.getProduct(name);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("display.jsp").forward(request,response);

    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("hiddenName");
        productBO.delete(name);
        displayProduct(request, response);
    }

    private void displayProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productBO.displayAll();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("display.jsp").forward(request,response);
    }


    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = productBO.getProduct(id);
        request.setAttribute("customer", product);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        String name = request.getParameter("customerName");

//        productBO.edit(id, product);
        displayProduct(request, response);
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("create.jsp");
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String messageName = Validate.validateName(name);

        String price = request.getParameter("price");
        String messagePrice = Validate.validatePrice(price);

        String quantity = request.getParameter("quantity");
        String messageQuantity = Validate.validatePositiveNumber(quantity);

        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String category = request.getParameter("category");

        request.setAttribute("name", name);
        request.setAttribute("messageName",messageName);

        request.setAttribute("price", price);
        request.setAttribute("messagePrice", messagePrice);

        request.setAttribute("quantity", quantity);
        request.setAttribute("messageQuantity", messageQuantity);

        request.setAttribute("description", description);
        request.setAttribute("category", category);

        boolean isValidated = messageName.equals("OK") && messagePrice.equals("OK") && messageQuantity.equals("OK");

        if (!isValidated) {
            request.getRequestDispatcher("create.jsp").forward(request, response);
        } else {

            Product product = new Product(name, price, quantity, color, description, category);
            productBO.create(product);
            displayProduct(request, response);
        }
    }

}
