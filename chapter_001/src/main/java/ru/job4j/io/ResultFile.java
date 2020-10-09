package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ResultFile {
    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }

    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result.txt"))) {
            int[][] table = ResultFile.multiple(4);
            oos.writeObject(table);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}