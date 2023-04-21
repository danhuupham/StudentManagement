package dan.controllers;

import dan.dao.CourseDao;
import dan.dao.StudentCourseDao;
import dan.models.Course;
import dan.models.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class CourseDetailsController extends HttpServlet {

    CourseDao courseDao = new CourseDao();
    StudentCourseDao studentCourseDao = new StudentCourseDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null) {
            response.sendRedirect("/course");
            return;
        }
        Course course = courseDao.get(id);
        if (course == null) {
            response.sendRedirect("/course");
            return;
        }
        showDetails(course, studentCourseDao.getStudentsByCourseId(id), request, response);
    }

    protected void showDetails(Course course, List<Student> students, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("details/");
        request.setAttribute("course", course);
        request.setAttribute("students", students);
        requestDispatcher.forward(request, response);
    }


}
