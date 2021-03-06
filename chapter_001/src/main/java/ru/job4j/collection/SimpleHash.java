package ru.job4j.collection;

import java.util.*;

public class SimpleHash<K, V> implements Iterable {
    private Entry<K, V>[] table;
    private int size = 16;
    private int modCount = 0;

    public SimpleHash() {
        this.table = new Entry[size];
    }

    boolean insert(K key, V value) {
        int hash = key.hashCode() % (size - 1);
        Entry<K, V> entry = table[hash];
        if (entry != null) {
            if (entry.k.equals(key)) {
                entry.v = value;
                modCount++;
                return true;
            }
        } else {
            Entry<K, V> newEntry = new Entry(key, value);
            table[hash] = newEntry;
            modCount++;
            size++;
            return true;
        }
        return false;
    }

    V get(K key) {
        int hash = key.hashCode() % (size - 1);
        Entry<K, V> entry = table[hash];
        if (entry != null && entry.k.equals(key)) {
            return entry.v;
        }
        return null;
    }

    boolean delete(K key) {
        int hash = key.hashCode() % (size - 1);
        Entry entry = table[hash];
        if (entry != null && entry.k.equals(key)) {
            table[hash] = null;
            modCount++;
            size--;
            return true;
        }
        return false;
    }

    public class Entry<K, V> {
        private K k;
        private V v;

        public Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public K getK() {
            return k;
        }

        public V getV() {
            return v;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleHash<?, ?> that = (SimpleHash<?, ?>) o;
        return size == that.size
                && Arrays.equals(table, that.table);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(table);
        return result;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = index; i < table.length; i++) {
                    if (table[i] != null) {
                        index = i;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Entry<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++];
            }
        };
    }
}