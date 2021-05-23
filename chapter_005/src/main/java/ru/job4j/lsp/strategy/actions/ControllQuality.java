package ru.job4j.lsp.strategy.actions;

import ru.job4j.lsp.strategy.food.Food;
import ru.job4j.lsp.strategy.storage.Storage;
import ru.job4j.lsp.strategy.storage.TemporaryWarehouse;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {

    private List<Storage> storage;
    private List<Food> foods = new ArrayList<>();

    public ControllQuality(List<Storage> storage) {
        this.storage = storage;
    }

    public void redistribute(Food food) {
        for (Storage storage : storage) {
            if (storage.accept(food)) {
                foods.add(food);
            }
        }
    }

    public void resort(List<Food> list) {
        foods.forEach(food -> new TemporaryWarehouse(list).getList().add(food));
        list.forEach(this::redistribute);
    }
}