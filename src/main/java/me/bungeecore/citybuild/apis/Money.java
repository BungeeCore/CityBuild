package me.bungeecore.citybuild.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Money {

    public Money() {
        connect();
    }

    private Connection connection;

    private boolean isConnected() {
        return connection != null;
    }

    public void connect() {
        if (!isConnected()) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Money?autoReconnect=true", "root", "");
            } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}
