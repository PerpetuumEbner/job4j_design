package ru.job4j.dip;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<User> list = new ArrayList<>();

    public void add() {
        list.add(new User());
    }
}