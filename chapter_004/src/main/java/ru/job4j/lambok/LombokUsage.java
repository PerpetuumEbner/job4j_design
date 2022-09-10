package ru.job4j.lambok;

public class LombokUsage {
    public static void main(String[] args) {
        var permission = Permission.of()
                .id(1)
                .name("name")
                .rules("user")
                .rules("admin")
                .build();
        System.out.println(permission);
    }
}