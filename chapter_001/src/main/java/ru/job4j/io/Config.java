package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Config {
    private final String path;
    private final Map<String, String> values = new LinkedHashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.path))) {
            String line = br.readLine();
            while (line != null) {
                String[] arrayLine = new String[0];
                if (!line.isEmpty() && line.indexOf('#') != 0) {
                    arrayLine = line.split("=");
                    values.put(arrayLine[0], arrayLine[1]);
                }
                Arrays.fill(arrayLine, null);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }
}