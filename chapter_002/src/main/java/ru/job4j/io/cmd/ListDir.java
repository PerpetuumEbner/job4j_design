package ru.job4j.io.cmd;

import java.util.LinkedList;
import java.util.List;

public class ListDir {
    private List<String> listDir;
    private int key;
    private String dirName;

    public ListDir() {
        this.listDir = new LinkedList<>();
    }

    public List<String> getListDir() {
        return listDir;
    }

    public int getKey() {
        return key;
    }

    public String getDirName() {
        return dirName;
    }
}