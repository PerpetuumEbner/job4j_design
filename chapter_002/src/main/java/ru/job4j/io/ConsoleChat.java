package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
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
            List<String> logList = new LinkedList<>();
            answerList(answer);
            String answers;
            String phrase = br.readLine();

            while (!phrase.equals(OUT)) {
                if (!phrase.equals(STOP)) {
                    answers = answer.get(randomKey());
                    System.out.println(answers);
                    logList.add(phrase + System.lineSeparator() + answers + System.lineSeparator());
                    phrase = br.readLine();
                } else {
                    while (!phrase.equals(CONTINUE)) {
                        logList.add(phrase + System.lineSeparator());
                        phrase = br.readLine();
                    }
                }
            }
            logList.add(phrase + System.lineSeparator());

            for (String l : logList) {
                bw.write(l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void answerList(Map<Integer, String> answerList) {
        int key = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            String line = br.readLine();
            while ((line != null)) {
                answerList.put(key, line);
                key++;
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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