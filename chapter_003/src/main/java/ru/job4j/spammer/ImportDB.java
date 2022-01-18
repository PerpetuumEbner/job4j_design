package ru.job4j.spammer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class ImportDB {
    private Properties cfg;
    private String dump;
    private Connection cnt;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().forEach(line -> {
                String[] user = line.split(";");
                if (user.length == 2 && !user[0].isEmpty() && !user[1].isEmpty()) {
                    users.add(new User(user[0], user[1]));
                } else {
                    throw new IllegalArgumentException();
                }

            });
        } catch (IOException e) {
            System.out.println("File not found.");
        }
        return users;
    }

    public void connection() {
        try {
            Class.forName(cfg.getProperty("jdbc.driver"));
            cnt = DriverManager.getConnection(
                    cfg.getProperty("jdbc.url"),
                    cfg.getProperty("jdbc.username"),
                    cfg.getProperty("jdbc.password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void writes(List<User> users) {
        for (User user : users) {
            try (PreparedStatement ps = cnt.prepareStatement(
                    "INSERT INTO spammer.public.users (name, email) VALUES (?, ?)")) {
                ps.setString(1, user.name);
                ps.setString(2, user.email);
                ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("./chapter_003/src/main/resources/spammer.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./chapter_003/src/main/resources/dump.txt");
        db.connection();
        db.writes(db.load());
    }
}