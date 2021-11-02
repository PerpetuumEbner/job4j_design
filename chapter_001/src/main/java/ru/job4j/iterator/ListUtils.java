package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

/**
 * Класс содержит методы обработки списков CRUD.
 *
 * @param <T> тип используемый в классе
 * @author yustas
 * @version 1.0
 */
public class ListUtils<T> {
    /**
     * Метод вставляет значение до индекса.
     *
     * @param list  список элементов
     * @param index индекс, перед которым нужно вставить значение.
     * @param value значение, которое необходимо вставить.
     * @param <T>   универтсальный тип.
     */
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.nextIndex() == index) {
                listIterator.add(value);
                break;
            }
            listIterator.next();
        }
    }

    /**
     * Метод вставляет значение после индекса.
     *
     * @param list  список элементов.
     * @param index индекс, после которого нужно вставить значение.
     * @param value значение, которое необходимо вставить.
     * @param <T>   универтсальный тип.
     */
    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.nextIndex() == index) {
                listIterator.next();
                listIterator.add(value);
                break;
            }
            listIterator.next();
        }
    }

    /**
     * Метод удаляет все элементы, которые удовлетворяют предикату.
     *
     * @param list   список элементов.
     * @param filter проверяет соблюдение некоторого условия.
     * @param <T>    универтсальный тип.
     */
    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            T object = listIterator.next();
            if (filter.test(object)) {
                listIterator.remove();
            }
        }
    }

    /**
     * Метод заменяет все элементы, которые удовлетворяют предикату.
     *
     * @param list   список элементов.
     * @param filter проверяет соблюдение некоторого условия.
     * @param value  значение, на которое необходимо заменить.
     * @param <T>    универтсальный тип.
     */
    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            T object = listIterator.next();
            if (filter.test(object)) {
                listIterator.set(value);
            }
        }
    }

    /**
     * Метод удаляет из списка list те элементы, которые есть в elements.
     *
     * @param list     список элементов.
     * @param elements список элементов, которые необходимо удалить.
     * @param <T>      универтсальный тип.
     */
    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> elementsIterator = elements.listIterator();
        while (elementsIterator.hasNext()) {
            ListIterator<T> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (elementsIterator.equals(listIterator.next())) {
                    listIterator.remove();
                }
            }
            elementsIterator.next();
        }
    }
}