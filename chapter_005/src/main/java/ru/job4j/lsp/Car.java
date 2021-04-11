package ru.job4j.lsp;

public class Car {
    private int weight;
    private int carryingCapacity;

    public Car(int weight, int carryingCapacity) {
        this.weight = weight;
        this.carryingCapacity = carryingCapacity;
    }

    public void shipping(int weight) {
        if (weight > carryingCapacity) {
            System.out.println("Excess weight!");
        }

        if (carryingCapacity <= 0) {
            System.out.println("The carrying capacity cannot be negative.");
        }
    }
}

class Truck extends Car {

    public Truck(int weight, int carryingCapacity) {
        super(weight, carryingCapacity);
    }

    public void shipping(int weight, int carryingCapacity) {
        if (weight > carryingCapacity) {
            System.out.println("Excess weight!");
        }

        if (carryingCapacity < -10) {
            System.out.println("The carrying capacity cannot be negative.");
        }
    }
}