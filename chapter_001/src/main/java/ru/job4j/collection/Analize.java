package ru.job4j.collection;

import java.util.List;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;

        for (int index = 0; index < previous.size(); index++) {
            if (!previous.get(index).name.equals(current.get(index).name) && current.get(index).name != null) {
                changed++;
            }
            if (!previous.get(index).name.isEmpty() && previous.get(index).name == null) {
                deleted++;
            }
            if (previous.get(index).name.isEmpty() && previous.get(index).name != null) {
                deleted++;
            }
        }
        return null;
    }

    public static class User {
        int id;
        String name;
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}