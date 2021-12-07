package ru.job4j.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class CSVReader {
    private static ArgsName argsName;
    private static int size;

    public static boolean validate() throws IllegalAccessException {
        path();
        delimiter();
        receiver();
        filter();
        return size == 4;
    }

    public static String path() throws IllegalAccessException {
        File file = new File(argsName.get("path"));
        if (!file.exists()) {
            throw new IllegalAccessException("Invalid directory.");
        }
        size++;
        return argsName.get("path");
    }

    public static void delimiter() throws IllegalAccessException {
        if (argsName.get("delimiter").equals(";" + System.lineSeparator())
                || argsName.get("delimiter").equals("," + System.lineSeparator())) {
            throw new IllegalAccessException("Invalid delimiter");
        }
        size++;
        argsName.get("delimiter");
    }

    public static void receiver() throws IllegalAccessException {
        File file = new File(argsName.get("out"));
        if (argsName.get("out").equals("stdout") || !file.isFile()) {
            throw new IllegalAccessException("Invalid parameter.");
        }
        size++;
    }

    public static void filter() throws IllegalAccessException {
        if (argsName.get("filter").isEmpty()) {
            throw new IllegalAccessException("Invalid parameter.");
        }
        size++;
        argsName.get("filter");
    }

    public static void handle(ArgsName argsName) throws Exception {
        List<Integer> list = new ArrayList<>();
        CSVReader.argsName = argsName;
        if (validate()) {
            try (Scanner scanner = new Scanner(argsName.get("path"))) {
                scanner.useDelimiter(argsName.get("delimiter"));
                String[] column = scanner.next().split(",");
                String[] args = argsName.get("filter").split(",");
                for (String arg : args) {
                    for (int index = 0; index < column.length; index++) {
                        if (arg.equals(column[index])) {
                            list.add(index);
                            break;
                        }
                    }
                }
                while (scanner.hasNext()) {
                    column = scanner.next().split(",");
                    for (Integer integer : list) {
                        System.out.println(column[integer]);
                    }
                }
            }
        }
    }
}