package ru.job4j.lsp.parking;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return length == car.length && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, length);
    }
}