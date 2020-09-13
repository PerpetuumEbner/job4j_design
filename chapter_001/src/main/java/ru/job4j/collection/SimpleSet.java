package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private final SimpleArray<E> simpleArray = new SimpleArray<>();

    public E get(int index) {
        return simpleArray.get(index);
    }

    public void add(E value) {
        if (!simpleArray.contains(value)) {
            simpleArray.add(value);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return simpleArray.iterator();
    }
}