package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConsoleChat {
    private final Map<Integer, String> answer = new LinkedHashMap<>();
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            String answers;
            String phrase = br.readLine(); // вводим строку в консоль
            while (!phrase.equals(OUT)) {
                if (!phrase.equals(STOP)) {
                    answers = randomAnswer(botAnswers); // то ответ
                    System.out.println(answers); // то выводим ответ
                    bw.write(phrase + System.lineSeparator() + answers + System.lineSeparator()); // записывавет фразу и ответ
                    phrase = br.readLine();
                } else {
                    while (!phrase.equals(CONTINUE)) {
                        bw.write(phrase + System.lineSeparator()); // записывавет фразу и продолжаем
                        phrase = br.readLine();
                    }
                }
            }
            bw.write(phrase + System.lineSeparator()); // записывавет фразу и заканчиваем
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String randomAnswer(String file) {
        int key = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while ((line != null)) {
                answer.put(key, line);
                key++;
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer.get(randomKey());
    }

    public int randomKey() {
        int from = 0;
        int to = answer.size();
        return (int) (from + (Math.random() * to));
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("C:\\projects\\job4j_design\\chapter_002\\src\\main\\resources\\log.txt",
                "C:\\projects\\job4j_design\\chapter_002\\src\\main\\resources\\Answers.txt");
        cc.run();
    }
}