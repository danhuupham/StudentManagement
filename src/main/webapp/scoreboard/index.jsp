<%@ page import="dan.models.StudentCourse" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dan.models.Scoreboard" %>
<%@ include file="../include/header.jsp" %>
<div class="container-fluid">
    <h2 class="text-center p-2">Scoreboard</h2>
    <form class="row g-3" action="${pageContext.request.contextPath}/scoreboard" method="post">
        <div class="col-md-6">
            <label for="id" class="form-label">Student's ID</label>
            <input type="text" class="form-control" id="id" name="id" required>
        </div>
        <div class="col-md-6">
            <label for="year" class="form-label">Year</label>
            <input type="number" class="form-control" id="year" name="year" required>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Show</button>
        </div>
    </form>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Student's name</th>
            <th scope="col">Course's name</th>
            <th scope="col">Score</th>
        </tr>
        </thead>
        <% ArrayList<Scoreboard> scoreboards = (ArrayList<Scoreboard>) request.getAttribute("scoreboards"); %>
        <tbody>
        <% if (scoreboards != null) { %>
        <% for (Scoreboard scoreboard : scoreboards) { %>
        <tr>
            <th scope="row"><%= scoreboard.getName() %>
            </th>
            <td><%= scoreboard.getCourse() %>
            </td>
            <td><%= scoreboard.getScore() %>
            </td>
        </tr>
        <% } %>
        <% } %>
        </tbody>
    </table>
</div>
<%@include file="../include/footer.jsp" %>
