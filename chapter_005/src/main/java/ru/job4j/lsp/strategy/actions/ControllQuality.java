package ru.job4j.lsp.strategy.actions;

import ru.job4j.lsp.strategy.food.Food;
import ru.job4j.lsp.strategy.storage.Storage;

import java.util.List;
import java.util.stream.Collectors;

public class ControllQuality {

    private final List<Storage> storage;

    public ControllQuality(List<Storage> storage) {
        this.storage = storage;
    }

    public void redistribute(Food food) {
        for (Storage storage : storage) {
            if (storage.accept(food)) {
                storage.add(food);
                break;
            }
        }
    }

    public void resort() {
        List<Food> foods = storage.stream().flatMap(s -> s.clear().stream()).collect(Collectors.toList());
        foods.forEach(this::redistribute);
    }
}