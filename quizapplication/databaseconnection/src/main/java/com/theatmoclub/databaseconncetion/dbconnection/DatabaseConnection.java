package com.theatmoclub.databaseconncetion.dbconnection;

import com.theatmoclub.databaseconncetion.exception.ConnectionFailedException;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * <h1>Database connection</h1>
 *
 */
public class DatabaseConnection {

   private static Map<String,String> property;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final Connection connection = DriverManager.getConnection(property.get("url"),property.get("user"), property.get("password"));

            return connection;
        } catch (Exception exception) {
            throw new ConnectionFailedException("FAILED TO CONNECTION");
        }
    }

    public static void database(Map<String, String> properties) {
        property = properties;
    }
}


