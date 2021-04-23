package ru.job4j.lsp.parking;

public class Car {
    private String name;
    private int length;

    public Car(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}