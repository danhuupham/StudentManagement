package dan.controllers;

import dan.dao.StudentDao;
import dan.models.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.Comparator;
import java.util.List;

public class StudentController extends HttpServlet {
    StudentDao studentDao = new StudentDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") == null) {
            response.sendRedirect("/login");
            return;
        }
        List<Student> students = studentDao.getAll();
        showStudents(students, request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") == null) {
            response.sendRedirect("/login");
            return;
        }
        String purpose = request.getParameter("purpose");
        Student student = studentDao.get(request.getParameter("id"));
        List<Student> students = studentDao.getAll();
        switch (purpose) {
            case "add":
                if (student != null) {
                    request.setAttribute("error", "Student already exists");
                    break;
                }
                studentDao.insert(new Student(request.getParameter("id"), request.getParameter("name"), Integer.parseInt(request.getParameter("grade")), Date.valueOf(request.getParameter("birthday")), request.getParameter("address"), request.getParameter("notes")));
                break;
            case "edit":
                if (student == null) {
                    request.setAttribute("error", "Student not found");
                    break;
                }
                if (!request.getParameter("name").equals("")) {
                    student.setName(request.getParameter("name"));
                }
                if (!request.getParameter("grade").equals("")) {
                    student.setGrade(Integer.parseInt(request.getParameter("grade")));
                }
                if (!request.getParameter("birthday").equals("")) {
                    student.setBirthday(Date.valueOf(request.getParameter("birthday")));
                }
                if (!request.getParameter("address").equals("")) {
                    student.setAddress(request.getParameter("address"));
                }
                studentDao.update(student);
                break;
            case "delete":
                if (student == null) {
                    request.setAttribute("error", "Student not found");
                    break;
                }
                studentDao.delete(student);
                break;
            case "search":
                String name = request.getParameter("search");
                showStudents(studentDao.findByName(name), request, response);
                return;
            case "sortByName":
                students.sort(Comparator.comparing(Student::getName));
                showStudents(students, request, response);
                return;
            case "sortByGrade":
                students.sort(Comparator.comparing(Student::getGrade));
                showStudents(students, request, response);
                return;
        }
        showStudents(studentDao.getAll(), request, response);
    }

    protected void showStudents(List<Student> students, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/");
        request.setAttribute("students", students);
        dispatcher.forward(request, response);
    }
}
