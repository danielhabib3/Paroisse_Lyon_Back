package com.example.Paroisse_Lyon_Back.services;

import com.example.Paroisse_Lyon_Back.model.User;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Optional;

@Service
public class loginService {

    public static void main(String[] args) {
        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/paroisse_lyon";  // Replace with your database URL
        String username = "root";  // Replace with your MySQL username
        String password = "database";  // Replace with your MySQL password
        String u = "Daniel";
        String p = "admin";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a query
            // query where username = 'Daniel' and password = 'admin'
            String query = "SELECT username, password, role FROM users WHERE username = '" + u + "'";  // Replace with your table name
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the result set
            while (resultSet.next()) {
                System.out.println("Column 2: " + resultSet.getString("username"));
                System.out.println("Column 3: " + resultSet.getString("password"));
                System.out.println("Column 4: " + resultSet.getString("role"));
            }

            // Step 5: Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // verify function
    public static Optional<User> verify(String username, String password) {
        Optional<User> user = Optional.empty();

        return user;
    }
}
