import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double num1 = Double.parseDouble(request.getParameter("fo"));
        double num2 = Double.parseDouble(request.getParameter("so"));
        String operator = request.getParameter("operator");
        double result;
        switch (operator) {
            case "addition":
                result = num1 + num2;
                break;
            case "subtraction":
                result = num1 - num2;
                break;
            case "multiplication":
                result = num1 * num2;
                break;
            default:
                result = num1 / num2;
        }

        request.setAttribute("result", result);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
