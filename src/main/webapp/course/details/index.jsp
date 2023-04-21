<%@ include file="../../include/header.jsp" %>
<%@ page import="dan.models.Course" %>
<%@ page import="dan.models.Student" %>
<%@ page import="java.util.ArrayList" %>
<div class="container-fluid">
    <h2 class="text-center p-2"> Course details</h2>
    <h4>
        <% Course course = (Course) request.getAttribute("course"); %>
        <% if (course != null) { %>
        <%= course.getName() %>
        <% } %>
    </h4>
    <h4 class="text-center"> List student</h4>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Grade</th>
            <th scope="col">Birthday</th>
            <th scope="col">Address</th>
            <th scope="col">Notes</th>
        </tr>
        </thead>
        <% ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("students"); %>
        <tbody>
        <% if (students != null) { %>
        <% for (Student student : students) { %>
        <tr>
            <th scope="row"><%= student.getId() %>
            </th>
            <td><%= student.getName() %>
            </td>
            <td><%= student.getGrade() %>
            </td>
            <td><%= student.getBirthday() %>
            </td>
            <td><%= student.getAddress() %>
            </td>
            <td><%= student.getNotes() %>
            </td>
        </tr>
        <% } %>
        <% } %>
        </tbody>
    </table>
</div>
<%@include file="../../include/footer.jsp" %>