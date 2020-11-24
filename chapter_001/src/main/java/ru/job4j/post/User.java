package ru.job4j.post;

import java.util.Objects;
import java.util.Set;

public class User {
    private String email;
    private Set<User> user;

    public User(String email, Set<User> user) {
        this.email = email;
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return Objects.equals(email, user1.email)
                && Objects.equals(user, user1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, user);
    }
}