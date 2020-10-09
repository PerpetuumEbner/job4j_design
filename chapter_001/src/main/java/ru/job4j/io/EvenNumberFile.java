package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("even.txt")) {
            int read;
            while ((read = fis.read()) != -1) {
                if (read % 2 == 0) {
                    System.out.println(read + " чётное");
                } else {
                    System.out.println(read + " нечётное ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}