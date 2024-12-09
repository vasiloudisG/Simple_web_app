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

@WebServlet("/user_details")
public class DisplayUserDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("id");
        System.out.println(userId);
        User user = null;

        try {
            Connection connection = DB.getCon();
            System.out.println("connection done");

            String SELECT_USER_SQL = "SELECT user_id, name, surname, gender, birthdate, work_address, home_address FROM users join addresses ON (users.id = addresses.user_id) WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL);

            preparedStatement.setString(1, userId);
            //System.out.println("done");
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                user = new User();
                user.setId(userId);
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setGender(resultSet.getString("gender"));
                user.setBirthdate(resultSet.getString("birthdate"));
                user.setWork_address(resultSet.getString("work_address"));
                user.setHome_address(resultSet.getString("home_address"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("user", user);
        request.getRequestDispatcher("user_details.jsp").forward(request, response);
    }
}
