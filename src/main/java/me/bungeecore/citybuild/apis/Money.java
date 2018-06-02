package me.bungeecore.citybuild.apis;

import java.sql.*;
import java.util.UUID;

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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void Update(String qry) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(qry);
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void createTable() {
        Update("CREATE TABLE IF NOT EXISTS Money (Name VARCHAR(100), UUID VARCHAR(100), Money VARCHAR(100))");
    }

    private boolean isPlayerExists(UUID uuid) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Money WHERE UUID = '" + uuid.toString() + "'");
            ResultSet set = ps.executeQuery();
            boolean get = set.next();
            set.close();
            ps.close();
            return get;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
}