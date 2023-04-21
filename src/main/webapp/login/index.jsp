<%@include file="../include/header.jsp" %>
<div class="container-fluid">
    <h1 class="p-3 text-center">Student Management</h1>
    <form class="w-50 mx-auto" method="post" action="">
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" id="username" name="username">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="remember">
            <label class="form-check-label" for="remember">Remember me</label>
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
    <div class="alert alert-danger mt-3" role="alert">
        <%= error %>
    </div>
    <% } %>
    <div class="text-center p-2">
        <p>Username: danhuupham</p>
        <p>Password: 123456</p>
    </div>
</div>
<%@include file="../include/footer.jsp" %>
