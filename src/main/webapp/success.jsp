<!DOCTYPE html>
<html>
<head>
    <title>Registration Successful</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="alert alert-success text-center" role="alert">
                    <h3 class="alert-heading">Registration Successful!</h3>
                    <h3>
                            <%
                                String message = (String) request.getAttribute("message");
                                System.out.print(message);
                            %>
                    </h3>
                </div>
                <div class="text-center mt-4">
                    <button class="btn btn-primary" onclick="location.href='index.jsp';">Home</button>
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
