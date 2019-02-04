package ru.neginskiy.tm.connection;

import java.sql.*;

import static ru.neginskiy.tm.util.AppConfig.*;

public class DBConnection {

    private Connection connection;

    public void initDB() {
        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
