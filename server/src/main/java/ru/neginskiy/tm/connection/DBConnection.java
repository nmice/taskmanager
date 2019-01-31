package ru.neginskiy.tm.connection;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DBConnection {

    public final Connection connection;

    public DBConnection(Connection connection) {
        this.connection = connection;
    }

    public void initDB() {
        String url = "jdbc:mysql://localhost:3636/tm_database";
        String username = "root";
        String password = "root";

//            Class.forName("com.mysql.jdbc.Driver");
        Driver driver = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO `user` (id,login,passwordHash) VALUES ('1234','MIKE',36050252useruser');");
            //ResultSet resultSet = statement.executeQuery("SELECT * FROM ");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

}
