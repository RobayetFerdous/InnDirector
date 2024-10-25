package com.robayet.inndirector.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
    private static final String DB_HOST = "localhost";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "robayet";
    private static final String DB_NAME = "inndirectordb";
    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + "/" + DB_NAME;
    private static Connection connection;
    private static ConnectionSingleton c = new ConnectionSingleton();
    public static Connection getConnection(){
        return connection;
    }
    private ConnectionSingleton(){
        try {
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
