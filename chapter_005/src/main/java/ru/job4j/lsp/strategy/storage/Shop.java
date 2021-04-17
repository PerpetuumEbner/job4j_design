package ru.job4j.lsp.strategy.storage;

import ru.job4j.lsp.strategy.food.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Distribution {
    List<Food> shop = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        return shop.add(food);
    }
}
