import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("description");

        int price = Integer.parseInt(request.getParameter("price"));
        int discount = Integer.parseInt(request.getParameter("discount"));

        double discountAmount = price * discount * 0.01;
        double discountPrice = price - discountAmount;

        request.setAttribute("product", product);
        request.setAttribute("price", price);
        request.setAttribute("discount", discount);
        request.setAttribute("discountAmount", discountAmount);
        request.setAttribute("discountPrice", discountPrice);

        request.getRequestDispatcher("display-discount.jsp").forward(request,response);
    }
}
