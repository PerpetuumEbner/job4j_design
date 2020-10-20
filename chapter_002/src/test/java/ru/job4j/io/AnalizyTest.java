package ru.job4j.io;

import org.junit.Test;

public class AnalizyTest {
    @Test
    public void whenAnalizyLog() {
        String pathSource = "./src/main/resources/source.csv";
        String pathTarget = "./src/main/resources/target.csv";
        Analizy analizy = new Analizy(pathSource, pathTarget);
        analizy.unavailable(pathSource, pathTarget);
    }
}