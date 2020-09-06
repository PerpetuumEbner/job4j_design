package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size;

    public T poll() { // достать элемент
        T value = in.pop();
        if (isEmpty()) {
            while (!isEmpty()) {
                value = in.pop();
                out.push(value);
                size--;
            }
        }
        return value;
    }

    public void push(T value) { // добавляет
        in.push(value);
        size++;
    }

    public boolean isEmpty() {
        return (size == 0);
    }
}