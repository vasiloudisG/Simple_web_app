<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="objects.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Display Users</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-10">
                <div class="card">
                    <div class="card-header bg-primary text-white text-center">
                        <h1>Users List</h1>
                    </div>
                    <div class="card-body">
                        <%-- Users table --%>
                        <table class="table table-hover">
                            <thead class="thead-light">
                                <tr>
                                    <th>Name</th>
                                    <th>Surname</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<User> users = (List<User>) request.getAttribute("users");
                                    if (users != null && !users.isEmpty()) {
                                        for (User user : users) {
                                %>
                                    <tr onclick="viewDetails('<%= user.getId() %>')" style="cursor: pointer;">
                                        <td><%= user.getName() %></td>
                                        <td><%= user.getSurname() %></td>
                                    </tr>
                                <%
                                        }
                                    } else {
                                %>
                                    <tr>
                                        <td colspan="2" class="text-center">No users found.</td>
                                    </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                        <button class="btn btn-secondary mt-3" onclick="location.href='index.jsp';">Home</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Include Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        // Redirect to user details page on row click
        function viewDetails(userId) {
            window.open(`user_details?id=${userId}`, '_blank');
        }
    </script>
</body>
</html>
