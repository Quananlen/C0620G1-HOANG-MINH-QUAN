package controller;

import model.Product;
import view.ProductService;
import view.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ProductServlet", urlPatterns = {"","/product"})
public class ProductServlet extends HttpServlet {
    ProductService listProduct = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "update":
                updateProduct(request,response);
            default:
                displayProduct(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "search":
                searchByName(request, response);
            default:
                displayProduct(request, response);
        }
    }

    public void displayProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = listProduct.getAll();
        request.setAttribute("listProduct", list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = listProduct.getAll();
        String id = request.getParameter("id");
        list.removeIf(p -> p.getId().equals(id));
        request.setAttribute("listProduct", list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    public void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = listProduct.getAll();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String manufacturer = request.getParameter("manufacturer");
        String price = request.getParameter("price");
        list.add(new Product(id, name, manufacturer,price));
        request.setAttribute("listProduct", list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

    public void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = listProduct.getAll();
        String id = request.getParameter("id");
        for (Product p : list) {
            if (p.getId().equals(id)) {
                p.setName(request.getParameter("name"));
                p.setManufacturer(request.getParameter("manufacturer"));
                p.setPrice(request.getParameter("price"));
                break;
            }
        }

        request.setAttribute("listProduct", list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    public void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> list = listProduct.getAll();
        Product product = null;
        for (Product p : list) {
            if (p.getName().equals(name)) {
                product = p;
                break;
            }
        }
        request.setAttribute("listProduct",list);
        request.setAttribute("result", product);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
