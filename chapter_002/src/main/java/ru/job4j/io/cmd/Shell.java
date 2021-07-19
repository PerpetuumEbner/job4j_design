package ru.job4j.io.cmd;

import java.util.Properties;

public class Shell implements Commands {
    private final Dir dir = new Dir();
    private final Properties properties = System.getProperties();


    @Override
    public void cd(String path) {
        String[] listPath = path.split("/");

        for (String strings : listPath) {
            if (strings.equals("~")) {
                String homePath = properties.getProperty("user.home");
                System.out.println(homePath);
            }

            if (strings.equals("")) {
                continue;
            }

            if (dir.getStack().contains(strings)) {
                dir.getStack().pollLast();
            }

            if (!strings.equals("..")) {
                dir.getStack().offerFirst(strings);
            } else {
                dir.getStack().pollLast();
            }
        }

        if (dir.getStack().isEmpty()) {
            dir.getStack().offerFirst("/");
        }
    }

    @Override
    public String pwd() {
        StringBuilder stringBuilder = new StringBuilder();
        if (dir.getStack().contains("/")) {
            stringBuilder.append(dir.getStack().pollFirst());
        }
        while (!dir.getStack().isEmpty() && !dir.getStack().contains("/")) {
            stringBuilder.append("/").append(dir.getStack().pollLast());
        }
        return new String(stringBuilder);
    }
}
