package com.flammen.jdbcmaven;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/hr?"
                    + "user=progress&password=progress");
            //conn = DriverManager.getConnection("jdbc:mysql://localhost/hr","progress" ,"progress");

            Statement stmt = conn.createStatement();
            int rowsAffected = stmt.executeUpdate(
                    "UPDATE employees SET salary = salary*1.1");

            System.out.println(rowsAffected);
            // ResultSet rs0 = stmt.executeQuery("SELECT first_name FROM employees");

            ResultSet rs = stmt.executeQuery(
                    "SELECT last_name, salary FROM employees");
            while (rs.next()) {
                String name = rs.getString("last_name");
                double salary = rs.getDouble("salary");
                System.out.println(name + " " + salary);
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
