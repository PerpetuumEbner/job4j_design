package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public void add(T value) {
        Node node = new Node(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T deleteFirst() {
        Node temp = head;
        if (head != null) {
            head = head.next;
        } else {
            throw new NoSuchElementException();
        }
        return (T) temp.value;
    }

    public T deleteLast() {
        if (size == 0) {
            throw  new NoSuchElementException();
        }

        Node temp = head;
        int index = 0;
        while (index < size - 1) {
            temp = temp.next;
            index++;
        }
        if (temp.next == null) {
            T currentValue = (T) temp.value;
            this.head = null;
            size--;
            return currentValue;
        }
        T currentValue = (T) temp.next.value;
        temp.next = null;
        return currentValue;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}