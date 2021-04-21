package ru.job4j.lsp.parking;

public class Parking {
    String name;
    int[][] length;

    public Parking(int[][] length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[][] getLength() {
        return length;
    }

    public void setLength(int[][] length) {
        this.length = length;
    }
}
