package ru.job4j.io.finder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        ArgsFile argsFile = new ArgsFile(args);
        argsFile.valid();

    }

    public static List<Path> search(ArgsFile args, Predicate<Path> predicate) throws IOException {
        FileFinder file = new FileFinder(predicate);
        Files.walkFileTree((Path) args, file);
        return file.getPaths();
    }
}