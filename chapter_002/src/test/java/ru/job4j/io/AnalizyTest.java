package ru.job4j.io;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.StringJoiner;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenAnalizyLog() throws IOException {
        File source = folder.newFile("source.csv");
        File target = folder.newFile("target.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01" + System.lineSeparator()
                    + "200 10:57:01" + System.lineSeparator()
                    + "400 10:58:01" + System.lineSeparator()
                    + "200 10:59:01" + System.lineSeparator()
                    + "500 11:01:02" + System.lineSeparator()
                    + "200 11:02:02");
        }
        new Analizy().unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        try (BufferedReader br = new BufferedReader(new FileReader(target))) {
            br.lines().forEach(sj::add);
        }
        assertThat(sj.toString(), is("10:58:01;10:59:01" + System.lineSeparator()
                + "11:01:02;11:02:02"));
    }
}