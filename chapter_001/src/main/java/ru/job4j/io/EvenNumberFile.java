package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void checkNumber(Integer i) {
        if (i % 2 == 0) {
            System.out.println(i + " чётное");
        } else {
            System.out.println(i + " нечётное ");
        }
    }

    public static void main(String[] args) {
        int i;
        try (FileInputStream fis = new FileInputStream("even.txt")) {
            StringBuilder sb = new StringBuilder();
            int read;
            while ((read = fis.read()) != -1) {
                if (read == 10) {
                    i = Integer.parseInt(sb.toString());
                    checkNumber(i);
                    sb.delete(0, sb.length());
                }
                if (read < 58 && read > 47) {
                    sb.append((char) read);
                }
            }
            i = Integer.parseInt(sb.toString());
            checkNumber(i);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Не верный формат");
        }
    }
}