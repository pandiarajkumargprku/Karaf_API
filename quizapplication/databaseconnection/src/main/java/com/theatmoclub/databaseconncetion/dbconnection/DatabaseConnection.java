package com.theatmoclub.databaseconncetion.dbconnection;

import com.theatmoclub.databaseconncetion.exception.ConnectionFailedException;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    public static Connection getConnection() {

        try {
            InputStream fileInputStream = new FileInputStream("etc/system.properties");
            Properties properties = new Properties();

            properties.load(fileInputStream);
            String url = properties.getProperty("karaf.jdbc.url");
            String userName = properties.getProperty("karaf.jdbc.user");
            String passWord = properties.getProperty("karaf.jdbc.password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            final Connection connection = DriverManager.getConnection(url, userName, passWord);

            return connection;
        } catch (Exception exception) {
            throw new ConnectionFailedException("FAILED TO CONNECTION");
        }
    }
}


