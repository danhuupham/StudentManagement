<%@ include file="../include/header.jsp" %>
<div class="container-fluid">
    <h2 class="text-center p-2">Add a new course</h2>
    <form class="row g-3" action="${pageContext.request.contextPath}/course" method="post">
        <input type="hidden" name="purpose" value="add">
        <div class="col-md-6">
            <label for="id" class="form-label">ID</label>
            <input type="text" class="form-control" id="id" name="id" required>
        </div>
        <div class="col-md-6">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="col-md-6">
            <label for="lecturer" class="form-label">Lecturer</label>
            <input type="text" class="form-control" id="lecturer" name="lecturer" required>
        </div>
        <div class="col-md-6">
            <label for="year" class="form-label">Year</label>
            <input type="number" class="form-control" id="year" name="year" required>
        </div>
        <div class="col-md-6">
            <label for="notes" class="form-label">Notes</label>
            <input type="text" class="form-control" id="notes" name="notes">
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-success">Add</button>
        </div>
    </form>
</div>
<%@include file="../include/footer.jsp" %>
