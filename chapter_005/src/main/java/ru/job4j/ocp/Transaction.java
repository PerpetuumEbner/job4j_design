package ru.job4j.ocp;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    public static class Money {
        private static int use(int value) {
            return value;
        }
    }

    public static class Products {
        Money money;

        public Products(Money money) {
            this.money = money;
        }

        public List<Products> buy(int amount) {
            List<Products> basket = new ArrayList<>();
            for (int index = 0; index < amount; index++) {
                basket.add(new Products(money));
            }
            return basket;
        }
    }
}