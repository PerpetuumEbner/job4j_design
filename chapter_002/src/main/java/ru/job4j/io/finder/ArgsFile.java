package ru.job4j.io.finder;

import java.io.File;

public class ArgsFile {
    private static final int DIRECTORY = 0;
    private static final int SEARCH_OPTION = 2;
    private static final int EXPANSION = 4;
    private static final int LOG = 5;
    private final String[] args;

    public ArgsFile(String[] args) {
        this.args = args;
    }

    public void validate() {
        if (args.length != 7) {
            System.out.println("Parameters error.");
        }
        if (!args[DIRECTORY].equals("-d")
                || !args[SEARCH_OPTION].equals("-n")
                || !args[LOG].equals("-o")) {
            throw new IllegalArgumentException("Invalid argument");
        }
        File dir = new File(args[DIRECTORY + 1]);
        if (!dir.exists()) {
            throw new IllegalArgumentException("Invalid directory.");
        }
    }

    public String directory() {
        return args[DIRECTORY + 1];
    }

    public String searchOption() {
        return args[SEARCH_OPTION + 1];
    }

    public String expansion() {
        return args[EXPANSION];
    }

    public String log() {
        return args[LOG + 1];
    }
}