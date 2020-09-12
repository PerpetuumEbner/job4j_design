package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {
    @Test
    public void whenAdd() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("first");
        String rsl = simpleSet.get(0);
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("first");
        String rsl = simpleSet.iterator().next();
        assertThat(rsl, is("first"));
    }
}