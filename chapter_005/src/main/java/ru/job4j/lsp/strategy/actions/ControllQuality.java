package ru.job4j.lsp.strategy.actions;

import ru.job4j.lsp.strategy.food.Food;
import ru.job4j.lsp.strategy.storage.Shop;
import ru.job4j.lsp.strategy.storage.Trash;
import ru.job4j.lsp.strategy.storage.Warehouse;

import java.util.Calendar;

public class ControllQuality {
    Calendar calendar = Calendar.getInstance();
    int shelfLife = 1;
    int daysPassed = 1;
    int percent;
    int discountPrice;

    public double expirationDateCheck(Food food) {
        shelfLife = food.getExpiryDate().get(Calendar.DAY_OF_MONTH)
                - food.getCreateDate().get(Calendar.DAY_OF_MONTH);
        daysPassed = calendar.get(Calendar.DAY_OF_MONTH) - shelfLife;
        percent = daysPassed / shelfLife * 100;
        return percent;
    }

    public void comparison(Food food) {
        if (expirationDateCheck(food) < 25) {
            new Warehouse().add(food);
        } else if (expirationDateCheck(food) >= 25 && expirationDateCheck(food) <= 75) {
            new Shop().add(food);
        } else if (expirationDateCheck(food) > 75) {
            addingDiscount(food);
            new Shop().add(food);
        } else {
            new Trash().add(food);
        }
    }

    public int addingDiscount(Food food) {
        if (expirationDateCheck(food) > 100) {
            discountPrice = food.getPrice() - food.getDiscount();
        }
        return discountPrice;
    }
}