package ru.job4j.ocp;

public class Logger {
    private class Log {
        public String write(String log) {
            return log;
        }
    }

    private class Programm {
        Log log = new Log();

        private void debug(String text) {
            log.write(text);
        }
    }
}