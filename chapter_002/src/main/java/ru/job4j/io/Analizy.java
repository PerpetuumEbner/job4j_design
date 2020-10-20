package ru.job4j.io;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Analizy {
    private final String pathSource;
    private final String pathTarget;
    private final Map<String, String> values = new LinkedHashMap<>();

    public Analizy(String source, String target) {
        this.pathSource = source;
        this.pathTarget = target;
    }

    public void load(String source) {
        String startTime;
        String endTime;

        try (BufferedReader br = new BufferedReader(new FileReader(source))) {
            String line = br.readLine();
            String[] arrayLine;
            while (line != null) {
                arrayLine = line.split(" ");
                if (arrayLine[0].equals("400") || arrayLine[0].equals("500")) {
                    startTime = arrayLine[1];
                    line = br.readLine();
                    arrayLine = line.split(" ");
                    while (!arrayLine[0].equals("200") && arrayLine[0].equals("300")) {
                        line = br.readLine();
                        arrayLine = line.split(" ");
                    }
                    endTime = arrayLine[1];
                    values.put(startTime, endTime);
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void safe(String target) {
        try (PrintWriter pw = new PrintWriter(target)) {
            for (Map.Entry<String, String> entry : values.entrySet()) {
                pw.write(entry.getKey() + ";" + entry.getValue() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void unavailable(String source, String target) {
        load(source);
        safe(target);
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