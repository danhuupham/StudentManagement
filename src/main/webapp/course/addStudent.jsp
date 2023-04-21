<%@ include file="../include/header.jsp" %>
<div class="container-fluid">
    <h2 class="text-center p-2">Add a student into a course</h2>
    <form class="row g-3" action="${pageContext.request.contextPath}/course" method="post">
        <input type="hidden" name="purpose" value="addStudent">
        <div class="col-md-6">
            <label for="studentId" class="form-label">Student's ID</label>
            <input type="text" class="form-control" id="studentId" name="studentId" required>
        </div>
        <div class="col-md-6">
            <label for="courseId" class="form-label">Course's ID</label>
            <input type="text" class="form-control" id="courseId" name="courseId" required>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-success">Add</button>
        </div>
    </form>
</div>
<%@include file="../include/footer.jsp" %>
