package actions;

import db.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            DB.checkAndCreateTables();
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Database initialization failed.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");
        birthdate = birthdate.split(" ")[0]; // Remove the time part
        String work_address = request.getParameter("work_address");
        String home_address = request.getParameter("home_address");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatementAddress = null;
        ResultSet rs = null;

        try {
            connection = DB.getCon();
            connection.setAutoCommit(false); // To resolve double registrations issue

            String INSERT_USER_SQL = "INSERT INTO users (name, surname, gender, birthdate) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, birthdate);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                rs = preparedStatement.getGeneratedKeys();
                int userId = 0;
                if (rs.next()) {
                    userId = rs.getInt(1);
                }

                String INSERT_ADDRESS_SQL = "INSERT INTO addresses (user_id, work_address, home_address) VALUES (?, ?, ?)";
                preparedStatementAddress = connection.prepareStatement(INSERT_ADDRESS_SQL);
                preparedStatementAddress.setInt(1, userId);
                preparedStatementAddress.setString(2, work_address);
                preparedStatementAddress.setString(3, home_address);
                preparedStatementAddress.executeUpdate();

                // Commit if both inserts were successful
                connection.commit();

                request.setAttribute("message", "Registration successful!");
                request.getRequestDispatcher("/success.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            // Rollback in case of an error
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ex.printStackTrace();
            request.setAttribute("message", "Registration failed: " + ex.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        } finally {
            try {
                if (rs != null) rs.close();
                if (preparedStatement != null) preparedStatement.close();
                if (preparedStatementAddress != null) preparedStatementAddress.close();
                if (connection != null) connection.setAutoCommit(true); // Reset auto-commit mode
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
