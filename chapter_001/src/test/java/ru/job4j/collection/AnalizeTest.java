package ru.job4j.collection;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AnalizeTest {
    @Test
    public void whenAdded() {
        Analize userAnalize = new Analize();

        List<Analize.User> usersPrevious = Arrays.asList(
                new Analize.User(1, "Mike"),
                new Analize.User(2, "Jon"),
                new Analize.User(3, "Bob"));

        List<Analize.User> usersCurrent = Arrays.asList(
                new Analize.User(1, "Mike"),
                new Analize.User(2, "Jon"),
                new Analize.User(3, "Bob"),
                new Analize.User(4, "Mia"),
                new Analize.User(5, "Alexa"));

        int added = userAnalize.diff(usersPrevious, usersCurrent).added;
        assertThat(added, is(2));
    }

    @Test
    public void whenChanged() {
        Analize userAnalize = new Analize();

        List<Analize.User> usersPrevious = Arrays.asList(
                new Analize.User(1, "Mike"),
                new Analize.User(2, "Jon"),
                new Analize.User(3, "Bob"));

        List<Analize.User> usersCurrent = Arrays.asList(
                new Analize.User(1, "Mike"),
                new Analize.User(2, "Mia"),
                new Analize.User(3, "Bob"));

        int changed = userAnalize.diff(usersPrevious, usersCurrent).changed;
        assertThat(changed, is(1));
    }

    @Test
    public void whenDeleted() {
        Analize userAnalize = new Analize();

        List<Analize.User> usersPrevious = Arrays.asList(
                new Analize.User(1, "Mike"),
                new Analize.User(2, "Jon"),
                new Analize.User(3, "Bob"));

        List<Analize.User> usersCurrent = Arrays.asList(
                new Analize.User(1, "Jon"),
                new Analize.User(2, "Bob"));

        int deleted = userAnalize.diff(usersPrevious, usersCurrent).deleted;
        assertThat(deleted, is(1));
    }
}