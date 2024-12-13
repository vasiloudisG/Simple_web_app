<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="objects.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Details</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header bg-info text-white text-center">
                        <h2>User Details</h2>
                    </div>
                    <div class="card-body">
                        <%
                            User user = (User) request.getAttribute("user");
                            if (user != null) {
                        %>
                            <p><strong>Name:</strong> <%= user.getName() %></p>
                            <p><strong>Surname:</strong> <%= user.getSurname() %></p>
                            <p><strong>Gender:</strong> <%= user.getGender() %></p>
                            <p><strong>Birthdate:</strong> <%= user.getBirthdate() %></p>
                            <p><strong>Work Address:</strong> <%= user.getWork_address() %></p>
                            <p><strong>Home Address:</strong> <%= user.getHome_address() %></p>
                        <%
                            } else {
                        %>
                            <p class="text-danger">No user found with the provided ID.</p>
                        <%
                            }
                        %>
                        <div class="text-center mt-4">
                            <button class="btn btn-primary" onclick="window.close();">Back</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Include Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
