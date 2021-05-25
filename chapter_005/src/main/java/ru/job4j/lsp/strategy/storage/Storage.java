package ru.job4j.lsp.strategy.storage;

import ru.job4j.lsp.strategy.food.Food;

import java.util.List;

public interface Storage {
    boolean accept(Food food);
    List<Food> clear();
    void add(Food food);
}