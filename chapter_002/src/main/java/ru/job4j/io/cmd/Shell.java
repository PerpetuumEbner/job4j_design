package ru.job4j.io.cmd;

public class Shell implements Commands {
    private final Dir dir = new Dir();

    @Override
    public void cd(String path) {
        if (path.equals("~")) {
            path = dir.getListDir().get(0);
            System.out.println(path);
        }

        if (path.equals("-")) {
            int index = dir.getKey() - 1;
            if (index > 0) {
                path = dir.getListDir().get(index);
                System.out.println(path);
            } else {
                path = dir.getListDir().get(0);
            }

        }

        for (String string : dir.getListDir()) {
            if (path.equals(string)) {
                path = string;
                System.out.println(path);
                break;
            }
        }
    }

    @Override
    public String pwd() {
        return dir.getDirName();
    }
}