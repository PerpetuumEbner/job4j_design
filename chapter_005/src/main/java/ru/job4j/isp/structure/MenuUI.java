package ru.job4j.isp.structure;

import java.util.*;

public class MenuUI implements Menu {
    private final Action action;

    public MenuUI(Action action) {
        this.action = action;
    }

    @Override
    public boolean add(String parentName, Item child) {
        boolean result = false;
        if (findBy(parentName).isPresent() || findBy(child.getName()).isEmpty()) {
            result = true;
        }
        action.getItem().add(child);
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
    public Optional<Item> findBy(String name) {
        Item result = null;
        int index = 0;
        while (index < action.getItem().size()) {
            Item item = action.getItem().get(index);
            List<Item> childList = item.getList();
            for (Item items : childList) {
                if (items.getName().equals(name)) {
                    result = item;
                    index = childList.size();
                    break;
                }
            }
            if (result == null) {
                index++;
            }
        }
        return Optional.ofNullable(result);
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