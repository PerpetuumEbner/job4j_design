package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private static Connection connection;
    private static Properties properties;

    public TableEditor(Properties properties) throws Exception {
        TableEditor.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
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
            connection = DriverManager.getConnection(url, login, password);
        }
    }

    public void createTable(String tableName) throws Exception {
        request(String.format("create table %s;", tableName));
    }

    public void dropTable(String tableName) throws Exception {
        request(String.format("drop table %s;", tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        request(String.format("alter table %s add column %s %s;", tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName, String type) throws Exception {
        request(String.format("drop table %s drop column %s %s;", tableName, columnName, type));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        request(String.format("alter table %s rename column %s to %s;", tableName, columnName, newColumnName));
    }

    public void request(String sql) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = TableEditor.properties;
        TableEditor tableEditor = new TableEditor(properties);
        tableEditor.createTable("Table");
        System.out.println(getTableScheme(connection, "Table"));
        tableEditor.dropTable("Table");
        System.out.println(getTableScheme(connection, "Table"));
        tableEditor.addColumn("Table", "Column", "Type");
        System.out.println(getTableScheme(connection, "Table"));
        tableEditor.dropColumn("Table", "Column", "Type");
        tableEditor.renameColumn("Table", "Column", "New Column");
    }
}