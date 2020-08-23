package ru.job4j.it;

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
        while (count < simpleArray.length) {
            if (simpleArray[count] == null) {
                simpleArray[count] = model;
                break;
            }
            count++;
        }
    }

    public void set(int index, T model) {
        simpleArray[Objects.checkIndex(index, count)] = model;
    }

    public void remove(int index) {
        System.arraycopy(simpleArray, Objects.checkIndex(index + 1, count), simpleArray, index, simpleArray.length - 1 - index);
        simpleArray[simpleArray.length - 1] = null;
        count--;
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