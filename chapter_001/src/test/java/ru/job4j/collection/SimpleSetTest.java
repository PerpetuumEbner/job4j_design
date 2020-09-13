package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;

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

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddDuplicate() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("first");
        simpleSet.add("first");
        assertThat(simpleSet.get(0), is("first"));
        assertThat(simpleSet.get(1), is("first"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("first");
        String rsl = simpleSet.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenAddThenItDuplicate() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("first");
        simpleSet.add("first");
        Iterator<String> iterator = simpleSet.iterator();
        assertThat(iterator.next(), is("first"));
        assertThat(iterator.hasNext(), is(false));
    }
}