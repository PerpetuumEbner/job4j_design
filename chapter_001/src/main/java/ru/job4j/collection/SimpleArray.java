package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container = new Object[10];
    private int count = 0;
    private int modCount = 0;

    public T get(int index) {
        Objects.checkIndex(index, count);
        return (T) container[index];
    }

    public void add(T model) {
        if (count == container.length - 1) {
            grow(container.length * 2);
            modCount++;
        }
        container[count++] = model;
        modCount++;
    }

    private void grow(int capacity) {
        Object[] newContainer = new Object[capacity];
        System.arraycopy(container, 0, newContainer, 0, count);
        container = (T[]) newContainer;
    }

    public boolean contains(T value) {
        for (Object container : container) {
            if (value.equals(container)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return index < count;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[index++];
            }
        };
    }
}