package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] simpleArray;
    private int count = 0;

    public SimpleArray(int size) {
        simpleArray = (T[]) new Object[size];
    }

    public void add(T model) {
        simpleArray[count++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, count);
        simpleArray[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, count);
        System.arraycopy(simpleArray, index + 1, simpleArray, index, simpleArray.length - 1 - index);
        simpleArray[simpleArray.length - 1] = null;
        count--;
    }

    public T get(int index) {
        Objects.checkIndex(index, count);
        return simpleArray[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < count;
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