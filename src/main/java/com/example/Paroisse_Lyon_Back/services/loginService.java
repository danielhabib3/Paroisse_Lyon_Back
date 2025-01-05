package com.example.Paroisse_Lyon_Back.services;

import com.example.Paroisse_Lyon_Back.model.User;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Optional;

@Service
public class loginService {

    private static Optional<User> getUserByUsername(String username) {
        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/paroisse_lyon";
        Optional<User> user = Optional.empty();

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, "root", "database");

            // Step 2: Create a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a query
            // query where username = 'Daniel' and password = 'admin'
            String query = "SELECT username, password, role FROM users WHERE username = '" + username.toLowerCase() + "'";  // Replace with your table name
            ResultSet resultSet = statement.executeQuery(query);

            if(resultSet.next()) {
                String usernameDB = resultSet.getString("username");
                String passwordDB = resultSet.getString("password");
                String roleDB = resultSet.getString("role");
                String telephoneDB = resultSet.getString("telephone");

                user = Optional.of(new User(usernameDB, passwordDB, roleDB, telephoneDB));
            }

            // Step 5: Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // verify function
    public static Optional<User> verify(String username, String password) {
        return getUserByUsername(username);
    }
}
