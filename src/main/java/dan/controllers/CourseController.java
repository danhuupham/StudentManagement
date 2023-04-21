package dan.controllers;

import dan.dao.CourseDao;
import dan.models.Course;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class CourseController extends HttpServlet {
    CourseDao courseDao = new CourseDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> courses = courseDao.getAll();
        showCourses(courses, request, response);
    }

    protected void showCourses(List<Course> courses, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("course/");
        request.setAttribute("courses", courses);
        requestDispatcher.forward(request, response);
    }
}
