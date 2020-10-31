package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<File> sources, File target) {
        for (File list : sources) {
            try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
                zip.putNextEntry(new ZipEntry(list.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(list))) {
                    zip.write(out.readAllBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> !p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void main(String[] args) throws IllegalAccessException, IOException {
        ArgZip argZip = new ArgZip(args);
        if (argZip.valid()) {
            List<File> sources = search(Path.of(argZip.directory()), argZip.exclude()).stream()
                    .map(Path::toFile).collect(Collectors.toList());
            File target = new File(argZip.output());
            new Zip().packFiles(sources, target);
        } else {
            throw new IllegalAccessException();
        }
    }
}