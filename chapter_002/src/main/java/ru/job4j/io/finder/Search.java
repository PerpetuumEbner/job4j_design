package ru.job4j.io.finder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        ArgsFile argsFile = new ArgsFile(args);
        argsFile.validate();
        Search search = new Search();
        Predicate<Path> predicate;
        List<Path> files = search.search(argsFile, predicate);
        search.write(argsFile, files);
    }

    public void write(ArgsFile args, List<Path> files) throws IOException {
        List<String> list = new ArrayList<>();
        for (Path file : files) {
            list.add(String.valueOf(file));
        }
        Files.write(Path.of(args.log()), list);
    }

    public static List<Path> search(ArgsFile args, Predicate<Path> predicate) throws IOException {
        FileFinder file = new FileFinder(predicate);
        Files.walkFileTree(Path.of(args.directory()), file);
        return file.getPaths();
    }
}