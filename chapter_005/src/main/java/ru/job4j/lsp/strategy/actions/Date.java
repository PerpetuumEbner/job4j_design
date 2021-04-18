package ru.job4j.lsp.strategy.actions;

import ru.job4j.lsp.strategy.food.Food;

import java.util.Calendar;

public class Date {
    public static double expirationDateCheck(Food food) {
        Calendar dateNow = Calendar.getInstance();
        int shelfLife = 1;
        int daysPassed = 1;
        int percent;

        shelfLife = food.getExpiryDate().get(Calendar.DAY_OF_MONTH) - food.getCreateDate().get(Calendar.DAY_OF_MONTH);
        daysPassed = dateNow.get(Calendar.DAY_OF_MONTH) - food.getCreateDate().get(Calendar.DAY_OF_MONTH);
        percent = daysPassed / shelfLife * 100;
        return percent;
    }
}