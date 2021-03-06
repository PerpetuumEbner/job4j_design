package ru.job4j.collection;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();

        int added = 0;
        int changed = 0;
        int deleted = 0;

        Map<Integer, User> mapCurrent = current.stream().collect(Collectors.toMap(User::getId, user -> user));
        for (User user : previous) {
            User mapUser = mapCurrent.remove(user.getId());
            if (mapUser == null) {
                deleted++;
            } else {
                if (!mapUser.equals(user)) {
                    changed++;
                }
            }
            added = current.size() + deleted - previous.size();
        }

        info.added = added;
        info.changed = changed;
        info.deleted = deleted;

        return info;
    }

    public static class User {
        int id;
        String name;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}