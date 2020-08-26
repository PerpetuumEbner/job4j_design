package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MemStoreTest {
    MemStore mem = new MemStore();
    User[] memStores = new User[]{
            new User("1"),
            new User("2"),
            new User("3"),
            new User("4"),
            new User("5"),
    };

    @Test
    public void whenAddElement() {
        mem.add(memStores[0]);
        mem.add(memStores[1]);
        mem.add(memStores[2]);
        mem.add(memStores[3]);
        mem.add(memStores[4]);
        assertThat(mem.findById("1"), is(memStores[0]));
        assertThat(mem.findById("5"), is(memStores[4]));
    }

    @Test
    public void whenReplaceElement() {
        mem.add(memStores[0]);
        mem.add(memStores[1]);
        mem.add(memStores[2]);
        mem.add(memStores[3]);
        mem.add(memStores[4]);
        assertThat(mem.replace("4", memStores[4]), is(true));
        assertThat(mem.findById("5"), is(memStores[4]));
    }

    @Test
    public void whenDeleteElement() {
        mem.add(memStores[0]);
        mem.add(memStores[1]);
        mem.add(memStores[2]);
        mem.add(memStores[3]);
        mem.add(memStores[4]);
        assertThat(mem.findById("3"), is(memStores[2]));
        assertThat(mem.delete("3"), is(true));
        assertNull(mem.findById("3"));
    }
}
