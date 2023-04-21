<%@ include file="../include/header.jsp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dan.models.Student" %>
<div class="container-fluid">
    <h2 class="text-center p-2"> Student List</h2>
    <form class="row row-cols-lg-auto g-3 align-items-center float-end"
          action="${pageContext.request.contextPath}/student"
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
    <form class="row row-cols-lg-auto g-3 align-items-center w-50" action="${pageContext.request.contextPath}/student"
          method="post">
        <div class="col-12">
            <select class="form-select" aria-label="sort" name="purpose">
                <option value="sortByName" selected>Sort by name</option>
                <option value="sortByGrade">Sort by grade</option>
            </select>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Sort</button>
        </div>
    </form>
    <div class="text-center">
        <a href="${pageContext.request.contextPath}/student/add.jsp" role="button" class="btn btn-success">Add
            student</a>
        <a href="${pageContext.request.contextPath}/student/edit.jsp" role="button" class="btn btn-warning">Edit
            student</a>
        <a href="${pageContext.request.contextPath}/student/delete.jsp" role="button" class="btn btn-danger">Delete
            student</a>
    </div>
    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
    <div class="alert alert-danger mt-3" role="alert">
        <%= error %>
    </div>
    <% } %>
</div>
<%@ include file="../include/footer.jsp" %>