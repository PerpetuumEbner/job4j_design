package ru.job4j.io;

public class ArgZip {
    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        boolean rst = true;
        if (args.length != 3) {
            System.out.println("Parameters error.");
            rst = false;
        }

        if (args[0].contains("-d") && args[1].contains("-e") && args[2].contains("-o")) {
            return true;
        }
        return rst;
    }

    public String directory() {
        if (args[0].contains("-d")) {
            args[0] = "c:\\project\\job4j_design\\";
        }
        return args[0];
    }

    public String exclude() {
        if (args[1].contains("-e")) {
            args[1] = "class";
        }
        return args[1];
    }

    public String output() {
        if (args[2].contains("-o")) {
            args[2] = "project.zip";
        }
        return args[2];
    }
}