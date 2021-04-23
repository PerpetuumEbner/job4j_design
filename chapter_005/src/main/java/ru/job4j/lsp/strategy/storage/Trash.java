package ru.job4j.lsp.strategy.storage;

import ru.job4j.lsp.strategy.actions.Date;
import ru.job4j.lsp.strategy.food.Food;

public class Trash implements Storage {
    @Override
    public boolean accept(Food food) {
        return Date.expirationDateCheck(food) > 75;
    }
}