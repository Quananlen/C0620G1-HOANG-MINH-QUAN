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
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"", "/UserServlet"})
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
                editUser(request, response);
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
                createForm(request, response);
                break;
            case "edit":
                editForm(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "searchByAddress":
                searchAddress(request, response);
                break;
            case "searchByID":
                searchID(request, response);
                break;
            case "sort":
                sortByName(request, response);
                break;
            case "permission":
                addUserPermission(request, response);
                break;
            case "test-without-tran":
                testWithoutTran(request, response);
                break;
            default:
                displayList(request, response);
        }
    }

    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {
        userBO.insertUpdateWithoutTransaction();
    }

    private void addUserPermission(HttpServletRequest request, HttpServletResponse response) {
        userBO.addUserPermission();
    }

    private void searchID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List<User> userList = userBO.searchID(id);
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("user/list.jsp").forward(request, response);
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userBO.sortByName();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("user/list.jsp").forward(request, response);
    }

    private void searchAddress(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address = request.getParameter("address");
        List<User> userList = userBO.searchAddress(address);
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("user/list.jsp").forward(request, response);
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Integer newId = Integer.valueOf(request.getParameter("newId"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String idCard = request.getParameter("idCard");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        userBO.edit(id, new User(newId, name, birthday, gender, phone, idCard, email, address));
        response.sendRedirect("/UserServlet");
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        request.getRequestDispatcher("user/edit.jsp").forward(request, response);
    }

    public void createForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("user/create.jsp");
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String idCard = request.getParameter("idCard");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        userBO.add(new User(name, birthday, gender, phone, idCard, email, address));
        response.sendRedirect("/UserServlet");
    }

    public void displayList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userBO.getAll();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("user/list.jsp").forward(request, response);
    }

    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        userBO.delete(id);
        response.sendRedirect("/UserServlet");
    }
}
