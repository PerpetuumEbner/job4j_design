package ru.job4j.io.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringJoiner;

public class Dir extends ListDir {

    public void add(List<String> listDir) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringJoiner joiner = new StringJoiner("/");
            String line = br.readLine();
            String[] list = line.split("/");

            for (String strings : list) {
                System.out.println(strings);
            }

            for (String string : list) {
                String join = String.valueOf(joiner.add(string));
                listDir.add(join);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(listDir);
    }
}