package ru.job4j.io.cmd;

import java.util.StringJoiner;

public interface Commands {
    void cd(String[] list);

    StringJoiner pwd();
}