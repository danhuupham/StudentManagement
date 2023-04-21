<%@ include file="../include/header.jsp" %>
<div class="container-fluid">
    <h2 class="text-center p-2">Add a new student</h2>
    <form class="row g-3" action="${pageContext.request.contextPath}/student" method="post">
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
            <label for="grade" class="form-label">Grade</label>
            <input type="number" class="form-control" id="grade" name="grade" required>
        </div>
        <div class="col-md-6">
            <label for="birthday" class="form-label">Birthday</label>
            <input type="date" class="form-control" id="birthday" name="birthday" required>
        </div>
        <div class="col-md-6">
            <label for="address" class="form-label">Address</label>
            <input type="text" class="form-control" id="address" name="address" required>
        </div>
        <div class="col-md-6">
            <label for="notes" class="form-label">Notes</label>
            <input type="text" class="form-control" id="notes" name="notes">
        </div>
        <div class="col-auto">
            <button type="submit" class="btn btn-success">Add</button>
        </div>
    </form>
</div>
<%@include file="../include/footer.jsp" %>
