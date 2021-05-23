package ru.job4j.lsp.strategy.storage;

import ru.job4j.lsp.strategy.food.Food;

import java.util.List;

public class TemporaryWarehouse {
    private final List<Food> list;

    public TemporaryWarehouse(List<Food> list) {
        this.list = list;
    }

    public List<Food> getList() {
        return list;
    }
}