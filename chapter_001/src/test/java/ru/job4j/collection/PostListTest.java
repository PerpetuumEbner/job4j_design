package ru.job4j.collection;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class PostListTest {
    @Test
    public void whenCheckPostList() {
        Map<String, Set<String>> postList = new LinkedHashMap<>();
        postList.put("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        postList.put("user2", Set.of("foo@gmail.com", "ups@pisem.net"));
        postList.put("user3", Set.of("xyz@pisem.net", "vasya@pupkin.com"));
        postList.put("user4", Set.of("ups@pisem.net", "aaa@bbb.ru"));
        postList.put("user5", Set.of("xyz@pisem.net"));

        Map<String, Set<String>> expected = Map.of(
                "user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru", "ups@pisem.net", "aaa@bbb.ru"),
                "user3", Set.of("xyz@pisem.net", "vasya@pupkin.com"));

        Map<String, Set<String>> result = PostList.mailList(postList);
        Assert.assertThat(result, Is.is(expected));
    }
}