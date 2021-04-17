package ru.job4j.lsp.strategy.food;

import java.util.Calendar;

public class Bread extends Food {
    public Bread(String name, Calendar expiryDate, Calendar createDate, int price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
