package ru.job4j.lsp.strategy.storage;

import ru.job4j.lsp.strategy.food.Food;

public interface Storage {
    boolean accept(Food food);
}