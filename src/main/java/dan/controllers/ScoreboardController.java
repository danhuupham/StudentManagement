package dan.controllers;

import dan.dao.CourseDao;
import dan.dao.StudentCourseDao;
import dan.dao.StudentDao;
import dan.models.Scoreboard;
import dan.models.StudentCourse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreboardController extends HttpServlet {
    StudentCourseDao studentCourseDao = new StudentCourseDao();
    StudentDao studentDao = new StudentDao();
    CourseDao courseDao = new CourseDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") == null) {
            response.sendRedirect("/login");
            return;
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("scoreboard/");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") == null) {
            response.sendRedirect("/login");
            return;
        }
        String id = request.getParameter("id");
        int year = Integer.parseInt(request.getParameter("year"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("scoreboard/");
        List<StudentCourse> studentCourses = studentCourseDao.getStudentCoursesByStudentIdAndYear(id, year);
        List<Scoreboard> scoreboards = new ArrayList<>();
        for (StudentCourse studentCourse : studentCourses) {
            scoreboards.add(new Scoreboard(studentDao.get(studentCourse.getStudentId()).getName(), courseDao.get(studentCourse.getCourseId()).getName(), studentCourse.getScore()));
        }
        request.setAttribute("scoreboards", scoreboards);
        requestDispatcher.forward(request, response);
    }
}
