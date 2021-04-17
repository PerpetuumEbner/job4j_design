package ru.job4j.lsp.strategy.food;

import java.util.Calendar;

public class Pasta extends Food {
    public Pasta(String name, Calendar expiryDate, Calendar createDate, int price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
