package ru.job4j.srp.io;

import java.io.*;

public class File implements ReadWriteFile {
    private static final String STRING = "";

    @Override
    public void writer(String file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(STRING);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    @Override
    public void read(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String string;
            while ((string = br.readLine()) != null) {
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}