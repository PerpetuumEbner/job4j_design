package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class UserStoreTest {
    UserStore user = new UserStore();
    User[] userStores = new User[]{
            new User("1"),
            new User("2"),
            new User("3"),
            new User("4"),
            new User("5"),
    };

    @Test
    public void whenAddElement() {
        user.add(userStores[0]);
        user.add(userStores[1]);
        user.add(userStores[2]);
        user.add(userStores[3]);
        user.add(userStores[4]);
        assertThat(user.findById("1"), is(userStores[0]));
        assertThat(user.findById("5"), is(userStores[4]));
    }

    @Test
    public void whenReplaceElement() {
        user.add(userStores[0]);
        user.add(userStores[1]);
        user.add(userStores[2]);
        user.add(userStores[3]);
        user.add(userStores[4]);
        assertThat(user.replace("4", userStores[4]), is(true));
        assertThat(user.findById("5"), is(userStores[4]));
    }

    @Test
    public void whenDeleteElement() {
        user.add(userStores[0]);
        user.add(userStores[1]);
        user.add(userStores[2]);
        user.add(userStores[3]);
        user.add(userStores[4]);
        assertThat(user.findById("3"), is(userStores[2]));
        assertThat(user.delete("3"), is(true));
        assertNull(user.findById("3"));
    }
}
