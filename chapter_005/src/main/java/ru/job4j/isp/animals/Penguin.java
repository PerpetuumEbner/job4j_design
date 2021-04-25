package ru.job4j.isp.animals;

public class Penguin implements Actions {
    @Override
    public void eat() {
        System.out.println("Is eating.");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins don't fly.");
    }

    @Override
    public void swim() {
        System.out.println("Is swimming.");
    }
}