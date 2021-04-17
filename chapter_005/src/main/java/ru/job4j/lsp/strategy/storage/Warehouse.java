package ru.job4j.lsp.strategy.storage;

import ru.job4j.lsp.strategy.food.Food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Distribution {
    List<Food> warehouse = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        return warehouse.add(food);
    }
}