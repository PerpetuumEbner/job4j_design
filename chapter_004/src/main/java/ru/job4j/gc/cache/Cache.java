package ru.job4j.gc.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class Cache {
    private final Map<String, SoftReference<String>> softCache = new HashMap<>();
    private final String path;

    public Cache(String path) {
        this.path = path;
    }

    private String read(String file) {
        String string = null;
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path + file))) {
            string = br.readLine();
            while (string != null) {
                stringBuilder.append(string);
                string = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    private String add(String file) {
        String string = read(file);
        if (string != null) {
            SoftReference<String> softString = new SoftReference<>(string);
            softCache.put(file, softString);
        }
        return string;
    }

    private String get(String key) {
        String string = "";
        SoftReference<String> softReference = softCache.get(key);
        if (softCache.containsKey(key)) {
            string = softReference.get();
        }
        if (string == null || string.isEmpty()) {
            string = read(key);
            softCache.put(key, new SoftReference<>(string));
        }
        return string;
    }

    public static void main(String[] args) {
        String path = "./chapter_004/src/main/resources/";
        Cache cache = new Cache(path);
        String fileName = "Names.txt";
        cache.get(fileName);
        String fileAddress = "Address.txt";
        cache.get(fileAddress);
    }
}