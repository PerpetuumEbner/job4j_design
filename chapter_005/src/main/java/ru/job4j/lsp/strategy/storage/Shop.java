package ru.job4j.lsp.strategy.storage;

import ru.job4j.lsp.strategy.actions.Date;
import ru.job4j.lsp.strategy.food.Food;

public class Shop implements Storage {
    @Override
    public boolean accept(Food food) {
        if (Date.expirationDateCheck(food) > 75) {
            food.setPrice(food.getPrice() - food.getDiscount());
        }
        return Date.expirationDateCheck(food) >= 25
                && Date.expirationDateCheck(food) < 100;
    }
}