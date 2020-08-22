package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] simpleArray;

    public SimpleArray() {
        simpleArray = (T[]) new Object[10];
    }

    public void add(T model) {
        IntStream.range(0, simpleArray.length)
                .filter(index -> simpleArray[index] == null)
                .findFirst().ifPresent(index -> simpleArray[index] = model);
    }

    public void set(int index, T model) {
        simpleArray[index] = model;
    }

    public void remove(int removeIndex) {
        simpleArray[removeIndex] = null;
        IntStream.range(removeIndex, simpleArray.length)
                .forEach(index -> simpleArray[index] = simpleArray[index + 1]);
    }

    public T get(int index) {
        return simpleArray[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < simpleArray.length && simpleArray[currentIndex] != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return simpleArray[currentIndex++];
            }
        };
    }
}