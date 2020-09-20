package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SimpleHashTest {
    @Test
    public void whenAdd() {
        SimpleHash<Integer, String> simpleHash = new SimpleHash<>();
        simpleHash.insert(0, "first");
        simpleHash.insert(1, "second");
        simpleHash.insert(2, "third");
        assertThat(simpleHash.get(0), is("first"));
    }

    @Test
    public void whenDelete() {
        SimpleHash<Integer, String> simpleHash = new SimpleHash<>();
        simpleHash.insert(0, "first");
        simpleHash.insert(1, "second");
        simpleHash.insert(2, "third");
        simpleHash.delete(1);
        assertThat(simpleHash.get(1), is(nullValue()));
    }

    @Test
    public void whenIteratorSimpleHash() {
        SimpleHash<Integer, String> simpleHash = new SimpleHash<>();
        simpleHash.insert(0, "first");
        simpleHash.insert(1, "second");
        simpleHash.insert(2, "third");
        Iterator<SimpleHash<Integer, String>.Entry<Integer, String>> iterator = simpleHash.iterator();
        Assert.assertThat(iterator.next().getK(), is(0));
        Assert.assertThat(iterator.hasNext(), is(true));
        Assert.assertThat(iterator.next().getK(), is(1));
        Assert.assertThat(iterator.hasNext(), is(true));
        Assert.assertThat(iterator.next().getK(), is(2));
        Assert.assertThat(iterator.hasNext(), is(false));
    }
}
