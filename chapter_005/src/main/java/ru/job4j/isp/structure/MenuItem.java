package ru.job4j.isp.structure;

import java.util.ArrayList;
import java.util.List;

public class MenuItem implements Action {
    private final List<Item> items = new ArrayList<>();

    @Override
    public List<Item> getItem() {
        return items;
    }
}