package ru.job4j.io.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ListIterator;
import java.util.Properties;
import java.util.Stack;
import java.util.StringJoiner;

public class Shell implements Commands {
    private final Dir dir = new Dir();
    private final Properties properties = System.getProperties();
    private final Stack<String> listDir = dir.getListDir();


    public void runCommandLine() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] list;
            while (true) {
                String line = br.readLine();

                if (line.equals("exit")) {
                    System.out.println("logout");
                    break;
                }

                list = line.split(" ");

                String string = list[1];
                String[] tempPath = string.split("/");
                String[] temp = new String[0];

                if (list[0].equals("cd") && list.length == 2 && !list[1].contains("/")) {
                    cd(temp);
                } else if (list[0].equals("pwd") && tempPath.length == 1) {
                    add(list);
                    pwd();
                } else {
                    temp = new String[tempPath.length];

                    System.arraycopy(tempPath, 0, temp, 0, tempPath.length);
                    add(tempPath);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(listDir);
    }

    public void add(String[] list) {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());

        for (String string : list) {
            String join = String.valueOf(joiner.add(string));
            listDir.add(join);
        }
    }


    @Override
    public void cd(String[] list) {
        if (list[0].equals("~")) {
            String path = properties.getProperty("user.home");
            System.out.println(path);

        } else if (list[0].equals("..")) {
            if (dir.getListDir().isEmpty()) {
                System.out.println("/");
            } else {
                dir.getListDir().peek();
            }
        } else {
            System.out.println("command not found");
        }
    }

    @Override
    public StringJoiner pwd() {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        int size = dir.getListDir().size();
        ListIterator<String> iterator = dir.getListDir().listIterator(size);
        while (iterator.hasPrevious()) {
            stringJoiner.add((CharSequence) iterator);
        }
        return stringJoiner;
    }

    public static void main(String[] args) {
        Shell shell = new Shell();
        shell.runCommandLine();
    }
}