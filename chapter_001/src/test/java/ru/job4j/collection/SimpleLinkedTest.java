package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class SimpleLinkedTest {
    private SimpleLinked<Integer> linked;

    @Before
    public void whenAddBefore() {
        linked = new SimpleLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
    }

    @Test
    public void whenGetElement() throws IllegalAccessException {
        assertThat(linked.get(0), is(1));
        assertThat(linked.get(1), is(2));
        assertThat(linked.get(2), is(3));
    }

    @Test
    public void whenCheckLength() {
        assertThat(linked.getSize(), is(3));
    }

    @Test
    public void whenIteratorElement() {
        Iterator<Integer> it = linked.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }
}