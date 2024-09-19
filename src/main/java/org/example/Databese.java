package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databese {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/MYSQL";
    private static final String DB_USER = "Danil";
    private static final String DB_PASSWORD = "astra121";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
