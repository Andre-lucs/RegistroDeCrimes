package com.registrodecrimes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            String connectionUrl = "jdbc:postgresql://localhost:5432/RegistroDeCrimes";
            return DriverManager.getConnection(connectionUrl, "admin", "admin");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
