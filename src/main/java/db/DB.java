package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    public static Connection con = null;
    static String url = "jdbc:mysql://localhost:3306/my_db";
    static String password = "Ravensburger1!";
    static String username = "root";

    public static Connection getCon() throws Exception {
        if (con == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful!");

        }
        return con;
    }
}
