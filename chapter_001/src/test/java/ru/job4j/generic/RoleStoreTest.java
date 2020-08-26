package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RoleStoreTest {
    RoleStore rol = new RoleStore();
    Role[] rolStores = new Role[]{
            new Role("1"),
            new Role("2"),
            new Role("3"),
            new Role("4"),
            new Role("5"),
    };

    @Test
    public void whenAddElement() {
        rol.add(rolStores[0]);
        rol.add(rolStores[1]);
        rol.add(rolStores[2]);
        rol.add(rolStores[3]);
        rol.add(rolStores[4]);
        assertThat(rol.findById("1"), is(rolStores[0]));
        assertThat(rol.findById("5"), is(rolStores[4]));
    }

    @Test
    public void whenReplaceElement() {
        rol.add(rolStores[0]);
        rol.add(rolStores[1]);
        rol.add(rolStores[2]);
        rol.add(rolStores[3]);
        rol.add(rolStores[4]);
        assertThat(rol.replace("4", rolStores[4]), is(true));
        assertThat(rol.findById("5"), is(rolStores[4]));
    }

    @Test
    public void whenDeleteElement() {
        rol.add(rolStores[0]);
        rol.add(rolStores[1]);
        rol.add(rolStores[2]);
        rol.add(rolStores[3]);
        rol.add(rolStores[4]);
        assertThat(rol.findById("3"), is(rolStores[2]));
        assertThat(rol.delete("3"), is(true));
        assertNull(rol.findById("3"));
    }
}
