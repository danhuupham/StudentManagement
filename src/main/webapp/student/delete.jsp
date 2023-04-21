<%@ include file="../include/header.jsp" %>
<div class="container-fluid">
    <h2 class="text-center p-2">Delete a student</h2>
    <form class="row g-3" action="${pageContext.request.contextPath}/student" method="post">
        <input type="hidden" name="purpose" value="delete">
        <div class="col-12">
            <label for="id" class="form-label">ID</label>
            <input type="text" class="form-control" id="id" name="id">
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-danger">Delete</button>
        </div>
    </form>
</div>
<%@ include file="../include/footer.jsp" %>
