package ru.job4j.lsp.strategy.storage;

import ru.job4j.lsp.strategy.food.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Distribution {
    List<Food> trash = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        return trash.add(food);
    }
}