package ru.job4j.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;

public class CSVReader {
    private static String[] args;

    public String[] getArgs() {
        return args;
    }

    public static boolean validate() throws IllegalAccessException {
        boolean rsl = true;
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
        File path = new File(args[0].substring(3));
        if (!path.isDirectory()) {
            throw new IllegalAccessException("Invalid directory.");
        }
        return args[0].substring(3);
    }

    public static String delimiter() throws IllegalAccessException {
        Pattern pattern = Pattern.compile("\\s\\S");
        if (!args[1].substring(11).equals(pattern)) {
            throw new IllegalAccessException("Invalid delimiter");
        }
        return args[1].substring(11);
    }

    public static String receiver() throws IllegalAccessException {
        if (!args[2].substring(5).equals("stdout")) {
            throw new IllegalAccessException("Invalid parameter.");
        }
        return args[2].substring(5);
    }

    public static String filter() throws IllegalAccessException {
        if (args[3].substring(8).isEmpty()) {
            throw new IllegalAccessException("Invalid parameter.");
        }
        return args[3].substring(8);
    }

    public static void handle(ArgsName argsName, String path, String delimiter) throws Exception {
        List<Integer> list = new ArrayList<>();
        if (validate()) {
            try (Scanner scanner = new Scanner(path)) {
                scanner.useDelimiter(delimiter);
                String[] column = scanner.next().split(",");
                String[] args = argsName.get("filter").split(",");
                for (String arg : args) {
                    for (int index = 0; index < column.length; index++) {
                        if (arg.equals(column[index])) {
                            list.add(index);
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