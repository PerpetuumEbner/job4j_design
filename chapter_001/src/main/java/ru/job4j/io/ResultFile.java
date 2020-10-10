package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;


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
        try (FileOutputStream fos = new FileOutputStream("result.txt")) {
            int[][] table = ResultFile.multiple(4);
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length; j++) {
                    fos.write(table[i][j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}