package ru.job4j.isp.structure;

import java.util.NoSuchElementException;

public class MenuUI implements Menu {
    private final Action action;

    public MenuUI(Action action) {
        this.action = action;
    }

    @Override
    public void add(String parentName, Item child) {
        if (action.getItem().isEmpty() || child == null) {
            action.getItem().add(new Item(parentName));
        } else {
            for (Item items : action.getItem()) {
                if (items.getName().equals(parentName)) {
                    items.getList().add(child);
                    break;
                }
            }
        }
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
    public void print() {
        for (Item item : action.getItem()) {
            System.out.println(item.getName());
            for (Item items : item.getList()) {
                System.out.println(items.getName());
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new MenuUI(new MenuItem());
        menu.add("1.", null);
        menu.add("2.", null);
        menu.add("1.", new Item("1.1."));
        menu.add("1.", new Item("1.2."));
        menu.add("2.", new Item("2.1."));
        menu.add("2.", new Item("2.2."));
        menu.print();
    }
}