package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    SimpleArray<Integer> simpleArray = new SimpleArray<>(5);

    @Test
    public void whenAddElement() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(3), is(4));
    }

    @Test
    public void whenSetElement() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        simpleArray.set(0, 6);
        assertThat(simpleArray.get(0), is(6));
    }

    @Test
    public void whenRemoveElement() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        simpleArray.remove(0);
        assertThat(simpleArray.get(0), is(2));
    }

    @Test
    public void whenGetElement() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(4), is(5));
    }

    @Test
    public void whenIterationElement() {
        Iterator<Integer> iterator = simpleArray.iterator();
        assertThat(iterator.hasNext(), is(false));
        simpleArray.add(1);
        assertThat(iterator.hasNext(), is(true));
        simpleArray.add(2);
        assertThat(iterator.hasNext(), is(true));
        simpleArray.add(3);
        assertThat(iterator.hasNext(), is(true));
        simpleArray.add(4);
        assertThat(iterator.hasNext(), is(true));
        simpleArray.add(5);
        assertThat(iterator.hasNext(), is(true));

        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.hasNext(), is(false));
    }
}