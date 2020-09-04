package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size;

    public T poll() {
        T value = in.pop();
        while (size != 0) {
            value = in.pop();
            out.push(value);
        }
        return value;
    }

    public void push(T value) {
        in.push(value);
        size++;
    }
}