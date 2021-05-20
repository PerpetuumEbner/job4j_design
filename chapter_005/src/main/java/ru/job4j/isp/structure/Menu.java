package ru.job4j.isp.structure;

import java.util.Optional;

public interface Menu {
    boolean add(String parentName, Item child);
    Item get(String name);
    Optional<Item> findBy(String name);
    void print();
}