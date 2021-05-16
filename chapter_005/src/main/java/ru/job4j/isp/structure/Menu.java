package ru.job4j.isp.structure;

public interface Menu {
    void add(String parentName, Item child);
    Item get(String name);
    void print();
}