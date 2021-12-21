package ru.job4j.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class CSVReader {
    private static ArgsName argsName;
    private static int size;
    private static String[] column;

    public static boolean validate() throws IllegalAccessException {
        path();
        delimiter();
        filter();
        return size == 3;
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
            try (Scanner scanner = new Scanner(new File(argsName.get("path")))) {
                parse(list);
                while (scanner.hasNext()) {
                    column = scanner.nextLine().split(argsName.get("delimiter"));
                    for (int index = 0; index < list.size(); index++) {
                        if (index == list.size() - 1) {
                            System.out.print(column[index] + System.lineSeparator());
                        } else {
                            System.out.print(column[index] + ";");
                        }
                    }
                }
            }
        }
    }

    public static void parse(List<Integer> listArgs) throws Exception {
        try (Scanner scanner = new Scanner(new File(argsName.get("path")))) {
            column = scanner.nextLine().split(argsName.get("delimiter"));
            String[] args = argsName.get("filter").split(",");
            for (String arg : args) {
                for (int index = 0; index < column.length; index++) {
                    if (arg.equals(column[index])) {
                        listArgs.add(index);
                        break;
                    }
                }
            }
        }
    }
}