package ru.job4j.io;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Analizy {
    private final String path;
    private final Map<String, String> values = new LinkedHashMap<>();

    public Analizy(final String path) {
        this.path = path;
    }

    public void unavailable(String source, String target) {
        String startTime;
        String endTime;

        try (BufferedReader br = new BufferedReader(new FileReader("source.csv"))) {
            String line = br.readLine();
            while (line != null) {
                String[] arrayLine = new String[0];
                arrayLine = line.split(" ");
                if (arrayLine[0].equals("400") || arrayLine[0].equals("500")) {
                    startTime = arrayLine[1];
                    Arrays.fill(arrayLine, null);
                    line = br.readLine();
                    arrayLine = line.split(" ");
                    if (arrayLine[0].equals("200") || arrayLine[0].equals("300")) {
                        endTime = arrayLine[1];
                    }
                    values.put(startTime, endTime);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}