package controller;

import BO.IUserBO;
import BO.UserBO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"","/UserServlet"})
public class UserServlet extends HttpServlet {
    IUserBO userBO = new UserBO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                createUser(request, response);
                break;
            case "edit":
                break;
            case "delete":
                deleteUser(request, response);
                break;
            default:
                displayList(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                createUser(request, response);
                break;
            case "edit":
                break;
            case "delete":
                deleteUser(request, response);
                break;
            default:
                displayList(request, response);
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String idCard = request.getParameter("idCard");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        userBO.add(new User(name,birthday, gender, phone, idCard, email, address));
//        List<User> userList = userBO.getAll();
//        request.setAttribute("userList", userList);
//        request.getRequestDispatcher("user/list.jsp").forward(request, response);
        response.sendRedirect("/UserServlet");
    }

    public void displayList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userBO.getAll();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("user/list.jsp").forward(request,response);
    }

    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        userBO.delete(id);
        response.sendRedirect("/UserServlet");
    }


}
