package ru.job4j.io.finder;

import java.nio.file.Path;
import java.util.function.Predicate;

public class ParametersFactory {
    public static Predicate<Path> predicate(ArgsFile args) {
        String type = args.expansion();
        Predicate<Path> result = p -> true;
        switch (type.toLowerCase()) {
            case "-f":
                result = p -> p.toFile().getName().equals(args.searchOption());
                break;
            case "-m":
                String s = preparePattern(args.searchOption());
                result = p -> p.toFile().getName().matches(s);
                break;
            case "-r":
                result = p -> p.toFile().getName().matches(args.searchOption());
                break;
            default:
                break;
        }
        return result;
    }

    private static String preparePattern(String pattern) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == '*') {
                sb.append(".*");
            } else if (c == '.') {
                sb.append("\\.");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
