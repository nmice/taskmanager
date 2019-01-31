package ru.neginskiy.tm.connection;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import ru.neginskiy.tm.entity.User;

import java.sql.*;

import static ru.neginskiy.tm.util.AppConfig.*;

public class DBConnection {

    private Connection connection;

    public void initDB() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
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
