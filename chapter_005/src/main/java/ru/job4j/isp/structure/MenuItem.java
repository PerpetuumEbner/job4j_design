package ru.job4j.isp.structure;

import java.util.ArrayList;
import java.util.List;

public class MenuItem extends Item implements Action {
    private final List<Item> items = new ArrayList<>();

    public MenuItem(String name) {
        super(name);
    }

    @Override
    public List<Item> getItem() {
        return items;
    }
}