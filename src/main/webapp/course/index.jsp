<%@ include file="../include/header.jsp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dan.models.Course" %>
<div class="container-fluid">
    <h2 class="text-center p-2"> Course List</h2>
    <form class="row row-cols-lg-auto g-3 align-items-center float-end"
          action="${pageContext.request.contextPath}/course"
          method="post">
        <input type="hidden" name="purpose" value="search">
        <div class="col-12">
            <input type="search" id="search" class="form-control" name="search" placeholder="Search by name"/>
        </div>
        <div class="col-12">
            <button id="search-button" type="submit" class="btn btn-primary">
                <i class="fas fa-search"></i>
            </button>
        </div>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Lecturer</th>
            <th scope="col">Year</th>
            <th scope="col">Notes</th>
            <th scope="col">Details</th>
        </tr>
        </thead>
        <% ArrayList<Course> courses = (ArrayList<Course>) request.getAttribute("courses"); %>
        <tbody>
        <% if (courses != null) { %>
        <% for (Course course : courses) { %>
        <tr>
            <th scope="row"><%= course.getId() %>
            </th>
            <td><%= course.getName() %>
            </td>
            <td><%= course.getLecturer() %>
            </td>
            <td><%= course.getYear() %>
            </td>
            <td><%= course.getNotes() %>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/course/details?id=<%= course.getId() %>">Details</a>
            </td>
        </tr>
        <% } %>
        <% } %>
        </tbody>
    </table>
    <form class="row row-cols-lg-auto g-3 align-items-center w-50" action="${pageContext.request.contextPath}/course"
          method="post">
        <div class="col-12">
            <select class="form-select" aria-label="sort" name="purpose">
                <option value="sortByName" selected>Sort by name</option>
            </select>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Sort</button>
        </div>
    </form>
    <div class="text-center">
        <a href="${pageContext.request.contextPath}/course/add.jsp" role="button" class="btn btn-success">Add
            course</a>
        <a href="${pageContext.request.contextPath}/course/edit.jsp" role="button" class="btn btn-warning">Edit
            course</a>
        <a href="${pageContext.request.contextPath}/course/delete.jsp" role="button" class="btn btn-danger">Delete
            course</a>
        <a href="${pageContext.request.contextPath}/course/addStudent.jsp" role="button" class="btn btn-success">Add
            student</a>
        <a href="${pageContext.request.contextPath}/course/deleteStudent.jsp" role="button" class="btn btn-danger">Delete
            student</a>
    </div>
    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
    <div class="alert alert-danger mt-3" role="alert">
        <%= error %>
    </div>
    <% } %>
</div>
<%@include file="../include/footer.jsp" %>