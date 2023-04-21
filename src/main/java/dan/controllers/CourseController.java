package dan.controllers;

import dan.dao.CourseDao;
import dan.dao.StudentCourseDao;
import dan.dao.StudentDao;
import dan.models.Course;
import dan.models.StudentCourse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class CourseController extends HttpServlet {
    CourseDao courseDao = new CourseDao();
    StudentCourseDao studentCourseDao = new StudentCourseDao();
    StudentDao studentDao = new StudentDao();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") == null) {
            response.sendRedirect("/login");
            return;
        }
        List<Course> courses = courseDao.getAll();
        showCourses(courses, request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") == null) {
            response.sendRedirect("/login");
            return;
        }
        String purpose = request.getParameter("purpose");
        Course course = courseDao.get(request.getParameter("id"));
        List<Course> courses = courseDao.getAll();
        String studentId = request.getParameter("studentId");
        String courseId = request.getParameter("courseId");
        System.out.println(studentId);
        System.out.println(courseId);
        switch (purpose) {
            case "add":
                if (course != null) {
                    request.setAttribute("error", "Course already exists");
                    break;
                }
                courseDao.insert(new Course(request.getParameter("id"), request.getParameter("name"), request.getParameter("lecturer"), Integer.parseInt(request.getParameter("year")), request.getParameter("notes")));
                break;
            case "edit":
                if (course == null) {
                    request.setAttribute("error", "Course not found");
                    break;
                }
                if (!request.getParameter("name").equals("")) {
                    course.setName(request.getParameter("name"));
                }
                if (!request.getParameter("lecturer").equals("")) {
                    course.setLecturer(request.getParameter("lecturer"));
                }
                if (!request.getParameter("year").equals("")) {
                    course.setYear(Integer.parseInt(request.getParameter("year")));
                }
                if (!request.getParameter("notes").equals("")) {
                    course.setNotes(request.getParameter("notes"));
                }
                courseDao.update(course);
                break;
            case "delete":
                if (course == null) {
                    request.setAttribute("error", "Course not found");
                    break;
                }
                courseDao.delete(course);
                break;
            case "addStudent":
                if (courseDao.get(courseId) == null) {
                    request.setAttribute("error", "Course not found");
                    break;
                }
                if (studentDao.get(studentId) == null) {
                    request.setAttribute("error", "Student not found");
                    break;
                }
                if (studentCourseDao.get(studentId, courseId) != null) {
                    request.setAttribute("error", "Student already enrolled");
                    break;
                }
                studentCourseDao.insert(new StudentCourse(studentId, courseId, 0));
                break;
            case "deleteStudent":
                if (courseDao.get(courseId) == null) {
                    request.setAttribute("error", "Course not found");
                    break;
                }
                if (studentDao.get(studentId) == null) {
                    request.setAttribute("error", "Student not found");
                    break;
                }
                if (studentCourseDao.get(studentId, courseId) == null) {
                    request.setAttribute("error", "Student not enrolled");
                    break;
                }
                studentCourseDao.delete(new StudentCourse(studentId, courseId, 0));
                break;
            case "search":
                String name = request.getParameter("search");
                showCourses(courseDao.findByName(name), request, response);
            case "sortByName":
                courses.sort(Comparator.comparing(Course::getName));
                showCourses(courses, request, response);
                return;
        }
        showCourses(courseDao.getAll(), request, response);
    }

    protected void showCourses(List<Course> courses, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("course/");
        request.setAttribute("courses", courses);
        requestDispatcher.forward(request, response);
    }
}
