package ru.job4j.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;

public class CSVReader {
    private static String[] args;
    private static ArgsName argsName;

    private static boolean rsl = true;

    public static boolean validate() throws IllegalAccessException {
        path();
        delimiter();
        receiver();
        filter();
        if (args.length != 4) {
            rsl = false;
        }
        return rsl;
    }

    public static String path() throws IllegalAccessException {
        File path = new File(argsName.get("path"));
        if (!path.isDirectory()) {
            throw new IllegalAccessException("Invalid directory.");
        }
        return argsName.get("path");
    }

    public static String delimiter() throws IllegalAccessException {
        Pattern pattern = Pattern.compile("\\W");
        if (!argsName.get("delimiter").equals(pattern)) {
            throw new IllegalAccessException("Invalid delimiter");
        }
        return argsName.get("delimiter");
    }

    public static void receiver() throws IllegalAccessException {
        if (!argsName.get("out").equals("stdout")) {
            throw new IllegalAccessException("Invalid parameter.");
        }
    }

    public static void filter() throws IllegalAccessException {
        if (argsName.get("filter").isEmpty()) {
            throw new IllegalAccessException("Invalid parameter.");
        }
        argsName.get("filter");
    }

    public static void handle(ArgsName argsName) throws Exception {
        List<Integer> list = new ArrayList<>();
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