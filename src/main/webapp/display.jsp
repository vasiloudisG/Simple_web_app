<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="objects.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Display Users</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        tr:hover {
            background-color: #f5f5f5;
            cursor: pointer;
        }
    </style>
    <script>
        // Redirect to user details page on row click
        function viewDetails(userId) {
            window.open(`user_details?id=${userId}`, '_blank');
        }
    </script>
</head>
<body>
    <h1>Users List</h1>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Surname</th>
            </tr>
        </thead>
        <tbody>
            <%-- Retrieve the users list from the request attribute --%>
            <%
                List<User> users = (List<User>) request.getAttribute("users");
                if (users != null && !users.isEmpty()) {
                    for (User user : users) {
            %>
                <tr onclick="viewDetails('<%= user.getId() %>')">
                    <td><%= user.getName() %></td>
                    <td><%= user.getSurname() %></td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="2">No users found.</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <br>
    <button onclick="location.href='index.jsp';">Home</button>
</body>
</html>
