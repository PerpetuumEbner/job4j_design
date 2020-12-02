package ru.job4j.collection;

import java.util.*;

public class PostList {
    public static Map<String, Set<String>> mailList(Map<String, Set<String>> postList) {
        Map<String, String> mapEmailUser = new LinkedHashMap<>();
        Map<String, Set<String>> mapUserEmail = new LinkedHashMap<>();

        for (Map.Entry<String, Set<String>> entry : postList.entrySet()) {
            String user = entry.getKey();
            Set<String> emails = entry.getValue();
            String stringUser = null;
            for (String email : emails) {
                if (mapEmailUser.containsKey(email)) {
                    stringUser = mapEmailUser.get(email);
                    break;
                }
            }
            if (stringUser == null) {
                mapUserEmail.put(user, new LinkedHashSet<>(emails));
            } else {
                mapUserEmail.get(stringUser
                ).addAll(emails);
                user = stringUser;
            }
            for (String email : emails) {
                mapEmailUser.putIfAbsent(email, user);
            }
        }
        return mapUserEmail;
    }
}