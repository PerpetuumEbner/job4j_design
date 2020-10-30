package ru.job4j.io;

import java.io.File;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() throws IllegalAccessException {
        directory();
        exclude();
        output();

        boolean rst = true;
        if (args.length != 3) {
            System.out.println("Parameters error.");
            rst = false;
        }
        return rst;
    }

    public String directory() throws IllegalAccessException {
        File file = new File(args[0].substring(3));
        if (!file.isDirectory()) {
            throw new IllegalAccessException("Invalid directory.");
        }
        return args[0].substring(3);
    }

    public String exclude() throws IllegalAccessException {
        if (!args[1].substring(3).equals(".xml")) {
            throw new IllegalAccessException("Invalid extension");
        }
        return args[1].substring(3);
    }

    public String output() throws IllegalAccessException {
        if (!args[2].substring(3).contains(".zip")) {
            throw new IllegalAccessException("Invalid extension");
        }
        return args[2].substring(3);
    }
}