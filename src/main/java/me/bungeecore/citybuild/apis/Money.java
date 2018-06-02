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
            } catch (SQLException ex) {
                ex.printStackTrace();
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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void registerPlayer(String name, UUID uuid) {
        if (isPlayerExists(uuid)) {
            return;
        }
        Update("INSERT INTO Money (Name, UUID, Money) VALUES ('" + name + "', '" + uuid.toString() + "', '100')");
    }

    public void setMoney(UUID uuid, int money) {
        Update("UPDATE Money SET Money = '" + money + "' WHERE UUID = '" + uuid.toString() + "'");
    }

    public int getMoney(UUID uuid) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Money WHERE UUID = '" + uuid.toString() + "'");
            ResultSet set = ps.executeQuery();
            set.next();
            int money = set.getInt("Money");
            set.close();
            ps.close();
            return money;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public void addMoney(UUID uuid, int money) {
        setMoney(uuid, (getMoney(uuid) + money));
    }

    public void removeMoney(UUID uuid, int money) {
        setMoney(uuid, (getMoney(uuid) - money));
    }
}