package actions;

import db.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");
        birthdate = birthdate.split(" ")[0];
        String work_address = request.getParameter("work_address");
        String home_address = request.getParameter("home_address");
        int result = 0;

        try {
            String INSERT_USER_SQL = "INSERT INTO users (name, surname, gender, birthdate) VALUES (?, ?, ?, ?)";
            Connection connection = DB.getCon();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, birthdate);
            result = preparedStatement.executeUpdate();
            //System.out.println(result);
            if (result > 0) {
                request.setAttribute("message", "Registration successful!");
                request.getRequestDispatcher("/success.jsp").forward(request, response);
            }

            int userId = 0;
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                userId = rs.getInt(1);
            }

            String INSERT_ADDRESS_SQL = "INSERT INTO addresses (user_id, work_address, home_address) VALUES (?, ?, ?)";
            PreparedStatement preparedStatementAddress = connection.prepareStatement(INSERT_ADDRESS_SQL);
            preparedStatementAddress.setInt(1, userId);
            preparedStatementAddress.setString(2, work_address);
            preparedStatementAddress.setString(3, home_address);
            preparedStatementAddress.executeUpdate();

        } catch (Exception ex){
            System.out.println(ex);
        }

    }
}