package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {

    public static Connection con = null;
    static String url = "jdbc:mysql://localhost:3306/my_db";
    static String password = "Ravensburger1!";
    static String username = "root";

    public static Connection getCon() throws Exception {
        if (con == null || con.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful!");

        }
        return con;
    }

    public static void checkAndCreateTables() { //check if tables users/addresses exist
        try (Connection connection = getCon();
             Statement stmt = connection.createStatement()) {

            ResultSet rs = connection.getMetaData().getTables(null, null, "users", null);
            if (!rs.next()) { //if rs.next() is empty, it doesn't exist
                System.out.println("'users' table not found. Creating it...");
                String createUsersTable = """
                        CREATE TABLE users (
                            ID INT AUTO_INCREMENT PRIMARY KEY,
                            NAME VARCHAR(255),
                            SURNAME VARCHAR(255),
                            GENDER VARCHAR(10),
                            BIRTHDATE DATE
                        );
                        """;
                stmt.execute(createUsersTable);
                System.out.println("'users' table created successfully!");
            } else {
                System.out.println("'users' table already exists.");
            }

            rs = connection.getMetaData().getTables(null, null, "addresses", null);
            if (!rs.next()) {
                System.out.println("'addresses' table not found. Creating it...");
                String createAddressesTable = """
                        CREATE TABLE addresses (
                            ID INT AUTO_INCREMENT PRIMARY KEY,
                            USER_ID INT,
                            HOME_ADDRESS VARCHAR(255),
                            WORK_ADDRESS VARCHAR(255),
                            FOREIGN KEY (USER_ID) REFERENCES users(ID) ON DELETE CASCADE
                        );
                        """;
                stmt.execute(createAddressesTable);
                System.out.println("'addresses' table created successfully!");
            } else {
                System.out.println("'addresses' table already exists.");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }}