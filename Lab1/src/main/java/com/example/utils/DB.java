package com.example.utils;
import java.sql.*;

public class DB {
    private Connection connection;
    private Statement statement;

    public DB() throws Exception {
        // WITH MYSQL
        String user = "mysql";
        String password = "prac";
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/epaw?" +
                        "user="+user+"&password="+password);
        statement = connection.createStatement();
    }

    // Execute queries
    public ResultSet executeSQL(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    // Disconnect from DB
    public void disconnectBD() throws SQLException {
        statement.close();
        connection.close();
    }
}
