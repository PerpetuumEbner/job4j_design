package ru.job4j.post;

import java.util.Objects;
import java.util.Set;

public class User {
    private String name;
    private Set<User> user;

    public User(String name) {
        this.name = name;
    }

    public User(String name, Set<User> user) {
        this.name = name;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user1 = (User) o;
        return Objects.equals(name, user1.name)
                && Objects.equals(user, user1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, user);
    }
}