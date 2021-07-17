package ru.job4j.io.cmd;

import java.util.Stack;

public class Dir {
    private final Stack<String> listDir;

    public Dir() {
        this.listDir = new Stack<>();
    }

    public Stack<String> getListDir() {
        return listDir;
    }
}