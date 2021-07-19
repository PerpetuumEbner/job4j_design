package ru.job4j.io.cmd;

import java.util.Deque;
import java.util.LinkedList;

public class Dir {
    private final Deque<String> stack;

    public Dir() {
        this.stack = new LinkedList<>();
    }

    public Deque<String> getStack() {
        return stack;
    }
}