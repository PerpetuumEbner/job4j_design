package ru.job4j.lsp.strategy.storage;

import ru.job4j.lsp.strategy.actions.Date;
import ru.job4j.lsp.strategy.food.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    private final List<Food> foods = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        return Date.expirationDateCheck(food) > 75;
    }

    @Override
    public List<Food> clear() {
        List<Food> list = new ArrayList<>(foods);
        foods.clear();
        return list;
    }

    @Override
    public void add(Food food) {
        foods.add(food);
    }
}