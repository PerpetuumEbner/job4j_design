package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinked<E> implements Iterable<E> {
    private Node head;
    private int size;
    private int modCount;

    public void add(E value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
                modCount++;
            }
            temp.setNext(new Node<E>(value));
        }
        size++;
    }

    public E get(int index) throws IllegalAccessException {
        int currentIndex = 0;
        Node temp = head;

        while (temp != null) {
            if (currentIndex == index) {
                return (E) temp.getValue();
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        throw new IllegalAccessException();
    }

    public int getSize() {
        return size;
    }

    private class Node<E> {
        private Node<E> next;
        private E value;

        public Node(E value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node index = head;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return index != null;
            }

            @Override
            public E next() {
                Node<E> temp = index;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                index = index.getNext();
                return (E) temp.value;
            }
        };
    }
}