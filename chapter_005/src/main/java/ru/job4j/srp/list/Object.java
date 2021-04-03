package ru.job4j.srp.list;

import java.util.ArrayList;
import java.util.List;

public class Object implements ChangeList {
    private static final List<Object> LIST = new ArrayList<>();

    @Override
    public List<Object> create() {
        for (int index = 0; index < 100; index++) {
            LIST.add(new Object());
        }
        return LIST;
    }

    @Override
    public List<Object> delete() {
        LIST.clear();
        return LIST;
    }
}