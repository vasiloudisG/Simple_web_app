<!DOCTYPE html>
<html>
<head>
    <title>Register User</title>
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
</head>
<body>
    <h1>Register New User</h1>
    <form action="reg" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="surname">Surname:</label>
        <input type="text" id="surname" name="surname" required><br>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="M">Male</option>
            <option value="F">Female</option>
        </select><br>

        <label for="birthdate">Birthdate:</label>
        <input type="text" id="birthdate" name="birthdate" required><br>

        <label for="work_address">Work Address:</label>
        <textarea id="work_address" name="work_address"></textarea><br>

        <label for="home_address">Home Address:</label>
        <textarea id="home_address" name="home_address"></textarea><br>

        <button type="submit">Submit</button>
        <button onclick="location.href='index.jsp';">Home</button>
    </form>
    <script>
        flatpickr("#birthdate", { dateFormat: "Y-m-d" });
    </script>
</body>
</html>