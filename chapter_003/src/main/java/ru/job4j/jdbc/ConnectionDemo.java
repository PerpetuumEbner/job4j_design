package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        Class.forName("org.postgresql.Driver");

        try (FileInputStream fis = new FileInputStream("./chapter_003/src/main/resources/app.properties")) {
            properties.load(fis);
            String url = properties.getProperty("jdbc.url");
            String login = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");
            try (Connection connection = DriverManager.getConnection(url, login, password)) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println(metaData.getUserName());
                System.out.println(metaData.getURL());
            }
        } catch (IOException e) {
            System.out.println("Файл не найден.");
        }
    }
}