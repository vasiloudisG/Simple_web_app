<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="objects.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Details</title>
</head>
<body>
    <h1>User Details</h1>
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
        <p>No user found with the provided ID.</p>
    <%
        }
    %>
    <br>
    <button onclick="window.close();">Back</button>
</body>
</html>
