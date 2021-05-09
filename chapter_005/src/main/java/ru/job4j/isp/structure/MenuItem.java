package ru.job4j.isp.structure;

import java.util.ArrayList;
import java.util.List;

public class MenuItem implements Action {
    private final List<Item> items = new ArrayList<>();

    public MenuItem() {
        items.add(new Item("1.", "Задача 1."));
        items.add(new Item("1.1.", "Задача 1.1."));
        items.add(new Item("1.1.1.", "Задача 1.1.1."));
        items.add(new Item("2.1.", "Задача 2.1."));
        items.add(new Item("2.2.", "Задача 2.2."));
        items.add(new Item("3.2.1.", "Задача 3.2.1."));
    }

    @Override
    public List<Item> getItem() {
        return items;
    }
}