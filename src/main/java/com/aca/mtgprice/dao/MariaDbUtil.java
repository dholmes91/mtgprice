package com.aca.mtgprice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.aca.mtgprice.util.DbConfig;

public class MariaDbUtil {

    private static final String connectionUrl = String.format("%s?user=%s&password=%s",
            DbConfig.getUrl(), DbConfig.getUsername(), DbConfig.getPassword());

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) {
        Connection connection = MariaDbUtil.getConnection();
        if (null != connection) {
            System.out.println("Connection established.");
        } else {
            System.out.println("Connection is null.");
        }
    }
}
