package dan.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") != null) {
            response.sendRedirect("/welcome");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login/");
            dispatcher.forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login/");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("danhuupham") && password.equals("123456")) {
            request.getSession().setAttribute("username", username);
            response.sendRedirect("/welcome");
        } else {
            request.setAttribute("error", "Invalid username or password");
            dispatcher.forward(request, response);
        }
    }
}
