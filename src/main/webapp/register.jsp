<!DOCTYPE html>
<html>
<head>
    <title>Register User</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Include Flatpickr -->
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header bg-primary text-white">
                        <h3 class="text-center">Register New User</h3>
                    </div>
                    <div class="card-body">
                        <form action="reg" method="post">
                            <div class="form-group">
                                <label for="name">Name:</label>
                                <input type="text" id="name" name="name" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="surname">Surname:</label>
                                <input type="text" id="surname" name="surname" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="gender">Gender:</label>
                                <select id="gender" name="gender" class="form-control" required>
                                    <option value="M">Male</option>
                                    <option value="F">Female</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="birthdate">Birthdate:</label>
                                <input type="text" id="birthdate" name="birthdate" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="work_address">Work Address:</label>
                                <textarea id="work_address" name="work_address" class="form-control"></textarea>
                            </div>
                            <div class="form-group">
                                <label for="home_address">Home Address:</label>
                                <textarea id="home_address" name="home_address" class="form-control"></textarea>
                            </div>
                            <div class="d-flex justify-content-between">
                                <button type="submit" class="btn btn-success">Submit</button>
                                <button type="button" class="btn btn-secondary" onclick="location.href='index.jsp';">Home</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Initialize Flatpickr -->
    <script>
        flatpickr("#birthdate", { dateFormat: "Y-m-d" });
    </script>
</body>
</html>
