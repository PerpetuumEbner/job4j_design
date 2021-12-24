package ru.job4j.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

/**
 * Класс принимает параметры для считывания данных из CSV файла и записывает в другой файл.
 *
 * @author yustas
 * @version 1.0
 */

public class CSVReader {
    private static ArgsName argsName;
    private static int size;
    private static String[] column;

    /**
     * Метод возвращает истину, если количество аргументов верное.
     *
     * @return возвращает истину, если условия соблюдены.
     */
    public static boolean validate() throws IllegalAccessException {
        path();
        delimiter();
        filter();
        return size == 3;
    }

    /**
     * Метод возвращает путь файла, который необходимо прочитать.
     *
     * @return путь файла.
     */
    public static String path() throws IllegalAccessException {
        File file = new File(argsName.get("path"));
        if (!file.exists()) {
            throw new IllegalAccessException("Invalid directory.");
        }
        size++;
        return argsName.get("path");
    }

    /**
     * Метод проверяет условие равенства одного из разделителей. Если оно не выполняется, то ошибка
     * IllegalAccessException.
     */
    public static void delimiter() throws IllegalAccessException {
        if (argsName.get("delimiter").equals(";" + System.lineSeparator())
                || argsName.get("delimiter").equals("," + System.lineSeparator())) {
            throw new IllegalAccessException("Invalid delimiter");
        }
        size++;
        argsName.get("delimiter");
    }

    /**
     * Метод проверяет наличие параметра, если он отсутствует, то ошибка IllegalAccessException.
     */
    public static void filter() throws IllegalAccessException {
        if (argsName.get("filter").isEmpty()) {
            throw new IllegalAccessException("Invalid parameter.");
        }
        size++;
        argsName.get("filter");
    }

    /**
     * Метод принимает параметры для их обработки. Данные считываются из CSV файла и необходимые столбцы записываются
     * в другой файл.
     *
     * @param argsName аргументы которые находятся в карте ключ-значение.
     */
    public static void handle(ArgsName argsName) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        CSVReader.argsName = argsName;
        if (validate()) {
            try (Scanner scanner = new Scanner(new File(argsName.get("path")))) {
                parse(list);
                while (scanner.hasNext()) {
                    column = scanner.nextLine().split(argsName.get("delimiter"));
                    for (int i = 0; i < column.length; i++) {
                        for (int index = 0; index < list.size(); index++) {
                            if (i == list.get(index)) {
                                if (index == list.size() - 1) {
                                    stringBuilder.append(column[i]).append(System.lineSeparator());
                                } else {
                                    stringBuilder.append(column[i]).append(";");

                                }
                            }
                        }
                    }
                }
                writeCSV(String.valueOf(stringBuilder));
                System.out.println(stringBuilder);
            }
        }
    }

    /**
     * Метод принимает строку и записывает её в файл.
     *
     * @param string строка, которую необходимо записать в файл.
     */
    public static void writeCSV(String string) throws IOException {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(argsName.get("out")))) {
            bf.write(string);
        }
    }

    /**
     * Метод записывает в список индексы столбцов, названия которых соответствуют переданному параметру.
     *
     * @param listArgs список куда записываются индексы столбцов.
     */
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