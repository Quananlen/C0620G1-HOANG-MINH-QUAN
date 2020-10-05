package controller;

import BO.service.ServiceBO;
import common.Validate;
import model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServiceServlet", urlPatterns = "/ServiceServlet")
public class ServiceServlet extends HttpServlet {
    ServiceBO serviceBO = new ServiceBO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                createService(request, response);
                break;
            default:
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                createServiceForm(request, response);
                break;
            default:
        }
    }

    private void createServiceForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("createService.jsp").forward(request, response);
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String messageId = Validate.ValidateServiceID(id);
        request.setAttribute("messageId", messageId);
        if (!messageId.equals("OK")) {
            request.setAttribute("id", id);
            request.getRequestDispatcher("create.jsp").forward(request, response);
        }

        String name = request.getParameter("name");
        String area = request.getParameter("area");
        String floor = request.getParameter("floor");
        String maxAmount = request.getParameter("maxAmount");
        String rentCost = request.getParameter("rentCost");
        String serviceTypeId = request.getParameter("serviceTypeId");
        String rentTypeId = request.getParameter("rentTypeId");
        String status = request.getParameter("status");
        Service service = new Service(id, name, area, floor, maxAmount, rentCost, serviceTypeId, rentTypeId, status);
        serviceBO.add(service);
        response.sendRedirect("/CustomerServlet");
    }
}
