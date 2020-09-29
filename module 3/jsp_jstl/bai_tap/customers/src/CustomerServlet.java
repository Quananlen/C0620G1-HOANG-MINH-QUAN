import models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CustomerServlet", urlPatterns = "")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customer> listCustomer = new ArrayList<>();
        listCustomer.add(new Customer("Luffy", "1/1/1111", "aaa111", "images/a.jpg"));
        listCustomer.add(new Customer("Naruto", "2/2/1112", "bbb222", "images/b.JPG"));
        listCustomer.add(new Customer("Songoku", "3/3/1113", "ccc333", "images/c.JPG"));
        listCustomer.add(new Customer("Natsu", "4/4/1114", "ddd444", "images/d.JPG"));

        request.setAttribute("list",listCustomer);
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }
}
