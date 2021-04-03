package ru.job4j.srp.singleton;

public class User {
    private static User instance;

    public static synchronized User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }
}