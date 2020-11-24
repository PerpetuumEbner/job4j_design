package ru.job4j.post;

import java.util.*;

public class PostList {
    public static Map<String, Set<User>> mailList(Map<String, Set<User>> postList) {
        return postList;
    }

    public static void main(String[] args) {
        Map<String, Set<String>> map = new LinkedHashMap<>();

        Set<String> user1 = new HashSet<>();
        Set<String> user2 = new HashSet<>();
        Set<String> user3 = new HashSet<>();
        Set<String> user4 = new HashSet<>();
        Set<String> user5 = new HashSet<>();

        user1.add("user1");
        user2.add("user2");
        user3.add("user3");
        user4.add("user4");
        user5.add("user5");

        map.put("xxx@ya.ru", user1);
        map.put("foo@gmail.com", user1);
        map.put("lol@mail.ru", user1);

        map.put("foo@gmail.com", user2);
        map.put("ups@pisem.net", user2);

        map.put("xyz@pisem.net", user3);
        map.put("vasya@pupkin.com", user3);

        map.put("ups@pisem.net", user4);
        map.put("aaa@bbb.ru", user4);

        map.put("xyz@pisem.net", user5);

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}