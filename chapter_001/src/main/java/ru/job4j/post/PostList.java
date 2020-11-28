package ru.job4j.post;

import java.util.*;

public class PostList {
    public static Map<String, Set<String>> mailList(Map<String, Set<String>> postList) {
        return postList;
    }

    public static void main(String[] args) {
        Map<String, Set<String>> map1 = new LinkedHashMap<>();

        map1.put("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        map1.put("user2", Set.of("foo@gmail.com", "ups@pisem.net"));
        map1.put("user3", Set.of("xyz@pisem.net", "vasya@pupkin.com"));
        map1.put("user4", Set.of("ups@pisem.net", "aaa@bbb.ru"));
        map1.put("user5", Set.of("xyz@pisem.net"));

        System.out.println();

        System.out.println("map1 Before:");
        for (Map.Entry<String, Set<String>> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println();

        map1.put("user1", Set.of("xxx@ya.ru"));
        map1.put("user1", Set.of("lol@mail.ru"));
        map1.put("user3", Set.of("vasya@pupkin.com"));
        map1.put("user4", Set.of("aaa@bbb.ru"));

        System.out.println("map1 After:");
        for (Map.Entry<String, Set<String>> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        Map<String, Set<String>> map2 = new LinkedHashMap<>();

        map2.put("xxx@ya.ru", Set.of("user1"));
        map2.put("foo@gmail.com", Set.of("user1"));
        map2.put("lol@mail.ru", Set.of("user1"));

        map2.put("foo@gmail.com", Set.of("user2"));
        map2.put("ups@pisem.net", Set.of("user2"));

        map2.put("xyz@pisem.net", Set.of("user3"));
        map2.put("vasya@pupkin.com", Set.of("user3"));

        map2.put("ups@pisem.net", Set.of("user4"));
        map2.put("aaa@bbb.ru", Set.of("user4"));

        map2.put("xyz@pisem.net", Set.of("user5"));

        System.out.println();

        System.out.println("map2 Before:");
        for (Map.Entry<String, Set<String>> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println();

        map2.put("xxx@ya.ru", Set.of("user1"));
        map2.put("lol@mail.ru", Set.of("user1"));
        map2.put("vasya@pupkin.com", Set.of("user3"));
        map2.put("aaa@bbb.ru", Set.of("user4"));

        System.out.println("map2 After:");
        for (Map.Entry<String, Set<String>> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}