package ru.job4j.isp.structure;

import java.util.NoSuchElementException;

public class MenuUI implements Menu {
    private final Action action;

    public MenuUI(Action action) {
        this.action = action;
    }

    @Override
    public void add(String parentName, Item child) {
        if (parentName.isEmpty()) {
            action.getItem().add(new Item(parentName));
        } else {
            for (Item items : action.getItem()) {
                if (items.getName().equals(parentName)) {
                    items.getList().add(child);
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
    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Menu menu = new MenuUI(new MenuItem());
    }
}