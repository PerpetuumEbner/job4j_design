package ru.job4j.isp.structure;

class Item {
    String number;
    String name;

    public Item(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}