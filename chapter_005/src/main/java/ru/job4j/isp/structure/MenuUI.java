package ru.job4j.isp.structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuUI implements Menu {
    private final Action action;

    public MenuUI(Action action) {
        this.action = action;
    }

    @Override
    public void start() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = true;
        while (exit) {
            System.out.println("Меню:");
            String item = "";
            String result = "";
            for (Item items : action.getItem()) {
                System.out.println(items.getName());
            }
            try {
                item = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int index = 0; index < action.getItem().size(); index++) {
                String nameItem = action.getItem().get(index).getNumber();
                if (nameItem.equals(item)) {
                    System.out.println("Выбрана задача " + nameItem + System.lineSeparator());
                    result = nameItem;
                    break;
                }
                if (item.equals("Выход")) {
                    exit = false;
                    break;
                }
            }
            if (!result.equals(item) && !item.equals("Выход")) {
                System.out.println("Не верный номер задачи." + System.lineSeparator());
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new MenuUI(new MenuItem());
        menu.start();
    }
}