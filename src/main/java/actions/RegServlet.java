package actions;

import db.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");
        String work_address = request.getParameter("work_address");
        String home_address = request.getParameter("home_address");
        int result = 0;

        try {
            String INSERT_USER_SQL = "INSERT INTO users (name, surname, gender, birthdate) VALUES (?, ?, ?, ?)";
            Connection connection = DB.getCon();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, birthdate);
            result = preparedStatement.executeUpdate();

        } catch (Exception ex){
            System.out.println(ex);
        }

    }
}