package ru.job4j.isp.structure;

import java.util.Optional;

public interface Menu {
    boolean add(Item parent, Item child);

    Item get(String name);

    Optional<Action> findBy(Item name);

    void print();
}