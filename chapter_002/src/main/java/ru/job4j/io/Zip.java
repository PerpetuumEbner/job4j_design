package ru.job4j.io;

import java.io.*;
import java.util.List;
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

    public static void main(String[] args) throws IllegalAccessException {
        ArgZip argZip = new ArgZip(args);
        if (argZip.valid()) {
            List<File> sources = Search.search(argZip.directory(), argZip.exclude());
            File target = new File(argZip.output());
            new Zip().packFiles(sources, target);
        } else {
            throw new IllegalAccessException();
        }
    }
}