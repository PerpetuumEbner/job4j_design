package ru.job4j.io.cmd;

public interface Commands {
    void cd(String path);

    String pwd();
}