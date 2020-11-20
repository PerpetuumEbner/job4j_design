package ru.job4j.io.finder;

import java.io.File;

public class ArgsFile {
    private static final int DIRECTORY = 0;
    private static final int NAME = 1;
    private static final int RECORDING_RESULT = 2;
    private final String[] args;

    public ArgsFile(String[] args) {
        this.args = args;
    }

    public void valid() {
        directory();
        validate();

        if (args.length != 3) {
            System.out.println("Parameters error.");
        }
    }

    public void directory() {
        File dir = new File(args[DIRECTORY]);
        if (!dir.exists()) {
            throw new IllegalArgumentException("Invalid directory.");
        }
    }

    public void validate() {
        if (!args[DIRECTORY].equals("-d")
                || !args[NAME].equals("-n")
                || !args[RECORDING_RESULT].equals("-o")) {
            throw new IllegalArgumentException("Invalid argument");
        }
    }
}