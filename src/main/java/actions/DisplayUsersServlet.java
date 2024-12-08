package actions;

import db.DB;
import objects.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/display_users")
public class DisplayUsersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> usersList = new ArrayList<>();
        try {
            Connection connection = DB.getCon();
            String SELECT_USERS_SQL = "SELECT name, surname, gender, birthdate, home_address, work_address FROM users join addresses ON (users.id = addresses.user_id)";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setGender(resultSet.getString("gender"));
                user.setBirthdate(resultSet.getString("birthdate"));
                user.setHome_address(resultSet.getString("home_address"));
                user.setWork_address(resultSet.getString("work_address"));
                usersList.add(user);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("users", usersList);
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }
}
