<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="objects.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Display Users</title>
</head>
<body>
    <h1>Users List</h1>
    <table border="1" cellpadding="10" cellspacing="0">
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
                <tr>
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
