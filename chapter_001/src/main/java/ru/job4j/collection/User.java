package ru.job4j.collection;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", children=" + children
                + '}';
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
        return children == user.children
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        User user1 = new User("Sasha", 1, new GregorianCalendar(2020, 1, 1));
        User user2 = new User("Sasha", 1, new GregorianCalendar(2020, 1, 1));
        Map<User, Object> userMap = new HashMap<>();
        userMap.put(user1, "first");
        userMap.put(user2, "second");

        for (Map.Entry<User, Object> entry : userMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}