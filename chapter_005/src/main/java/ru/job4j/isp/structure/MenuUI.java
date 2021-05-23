package ru.job4j.isp.structure;

import java.util.*;

public class MenuUI implements Menu {
    private final Action action;

    public MenuUI(Action action) {
        this.action = action;
    }

    @Override
    public boolean add(Item parent, Item child) {
        boolean result = false;
        Optional<Action> parentItem = findBy(parent);
        if (parentItem.isPresent() && findBy(child).isEmpty()) {
            parentItem.get().getItem().add(child);
            result = true;
        }
        return result;
    }

    @Override
    public Item get(String name) {
        Item result = null;
        for (Item item : action.getItem()) {
            if (item.getName().equals(name)) {
                result = item;
            }
        }
        if (result == null) {
            throw new NoSuchElementException("Item no found");
        }
        return result;
    }

    @Override
    public Optional<Action> findBy(Item name) {
        Optional<Action> result = Optional.empty();
        Queue<Action> queue = new LinkedList<>();
        queue.offer(this.action);
        while (!queue.isEmpty()) {
            Action item = queue.poll();
            if (item.equals(name)) {
                result = Optional.of(item);
                break;
            }
            queue.add(action);
        }
        return result;
    }

    @Override
    public void print() {
        for (Item item : action.getItem()) {
            System.out.println(item.getName());
            for (Item items : item.getList()) {
                System.out.println(items.getName());
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new MenuUI(new MenuItem("root"));
        menu.add(new Item("1"), new Item("1"));
        menu.add(new Item("2"), new Item("2"));
        menu.add(new Item("1"), new Item("1.1."));
        menu.add(new Item("1"), new Item("1.2."));
        menu.add(new Item("2"), new Item("2.1."));
        menu.add(new Item("2"), new Item("2.2."));
        menu.print();
    }
}