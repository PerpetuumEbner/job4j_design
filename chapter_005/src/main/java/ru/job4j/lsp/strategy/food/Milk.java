package ru.job4j.lsp.strategy.food;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Milk extends Food {
    public Milk(String name, Calendar expiryDate, Calendar createDate, int price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}