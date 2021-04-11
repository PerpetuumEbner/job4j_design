package ru.job4j.lsp;

public class Human {
    private int age;

    public int check(int age) throws Exception {
        if (age < 0) {
            throw new Exception("Age cannot be negative.");
        }
        return age;
    }
}

class Women extends Human {
    public int check(int age) {
        return age + 50;
    }
}